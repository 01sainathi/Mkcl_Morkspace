package com.app;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.ExamEvent;
import com.app.service.ExcelService;
import com.app.service.PdfService;

@Controller
@RequestMapping("/convert")
public class PdfController {
	ExcelService eServ = new ExcelService();
	PdfService pdfServ = new PdfService();
	@GetMapping("")
	public String page() {
		return "Convert";
	}
	
	@GetMapping("/h_to_p")
	public String htmlToPdf() {
		return "htmlToPdf";
	}
	
	@GetMapping("/e_to_p")
	public String excelToPdf() {
		return "ExcelToPdf";
	}

	@GetMapping("/htmlToPdf")
	@ResponseBody
	public ResponseEntity<byte[]> save(@RequestParam long examEventID, 
			@RequestParam String name,
			@RequestParam String examEventCode,
			@RequestParam String defaultLanguageID) {
		ExamEvent e = new ExamEvent(examEventID, name, examEventCode, defaultLanguageID);
		
		System.out.println("Inside save EE");
		System.out.println(e.toString());
		
		byte[] pdfBytes = pdfServ.generatePDF(e);
		if(pdfBytes!=null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "info.pdf");
			headers.setContentLength(pdfBytes.length);
			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/excelToPdf")
	@ResponseBody
	public ResponseEntity<byte[]> saveExcelFile(@RequestParam("excel") CommonsMultipartFile file, HttpSession s) {
		System.out.println("----------------------->"+file.getName());
		System.out.println("----------------------->"+file.getOriginalFilename());
		System.out.println("----------------------->"+file.getSize());
		System.out.println("----------------------->"+file.getContentType());
		System.out.println("----------------------->"+file.getStorageDescription());
		
		byte[] data = file.getBytes();
		//we have to save this file to server...
		
		String path = "D:/ExcelFiles/"+file.getOriginalFilename();
		System.out.println("----------------------->"+path);
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			
			List<ExamEvent> list = eServ.readExcel(path);
			
			byte[] pdfBytes = pdfServ.generatePDFOutOfList(list);
			
			if(pdfBytes!=null) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_PDF);
				headers.setContentDispositionFormData("filename", "info.pdf");
				headers.setContentLength(pdfBytes.length);
				return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/testing")
	public String test() {
		
		//Create empty html document
		var document = new com.aspose.html.HTMLDocument();
		
		//Add heading
		//create aheading element
		var h2 = (com.aspose.html.HTMLHeadingElement)document.createElement("h2");
		
		//Create a text element
		var text = document.createTextNode("This is a simple heading!");
		
		//add text ele to the heading 
		h2.appendChild(text);
		
		//add heading to the document
		document.getBody().appendChild(h2);
		
		//save the html document to a file
		document.save("D:/create-html-advanced.html");
		return "abc";
	}
}
