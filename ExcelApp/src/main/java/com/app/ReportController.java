package com.app;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;

import org.apache.pdfbox.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.app.model.Mark;
import com.app.model.School;
import com.app.model.Student;
import com.app.model.StudentInfo;
import com.app.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {

	ReportService rServ = new ReportService();

	@GetMapping("/gen_report")
	public String genReport() {
		return "GenerateReport";
	}

	@PostMapping(value = "/reportCardPdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> generateReportCard(@RequestBody String data) throws IOException {

		System.out.println(data);
		
		//Create html file of result
		var document = new com.aspose.html.HTMLDocument(data, "D:/");
		String path = "D:/Report/html/created.html";
		document.save(path);

		
		//CReate pdf of result html file
		File htmlFile = new File(path);
		Document doc = Jsoup.parse(htmlFile, "UTF-8");
		doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
		String pdfPath = "D:/Report/PDF/created.pdf";
		try (OutputStream os = new FileOutputStream(pdfPath)) {
			ITextRenderer renderer = new ITextRenderer();
			SharedContext context = renderer.getSharedContext();
			context.setPrint(true);
			context.setInteractive(false);
			String baseUrl = FileSystems.getDefault().getPath("D:/Report/html").toUri().toURL().toString();
			renderer.setDocumentFromString(doc.html(), baseUrl);
			renderer.layout();
			renderer.createPDF(os);
			System.out.println("Done");
		}
		
		//sending that pdf to client as byteArray
		File file = new File(pdfPath);
		FileInputStream fis = new FileInputStream(file);
		byte[] pdfBytes = new byte[(int) file.length()];
		fis.read(pdfBytes);
		fis.close();
		
		System.out.println(pdfBytes.length);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", "result.pdf");
		headers.setContentLength(pdfBytes.length);
		return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	}

	@GetMapping("/reportCard")
	@ResponseBody
	public String getReportCard(@RequestParam String name, @RequestParam String roll_no) {
		System.out.println(name + " " + roll_no);

		Student stu = rServ.getStudent(name, roll_no);
		if (stu == null) {
			return "Not Found";
		}
		System.out.println("---------->" + stu);
		Mark m = rServ.getMarks(stu.getFkMarkId());
		System.out.println("---------->" + m);

		School s = rServ.getSchool(stu.getFkSchoolId());
		System.out.println("---------->" + s);

		StudentInfo info = new StudentInfo(stu, m, s);

		return info.toString();

	}
}
