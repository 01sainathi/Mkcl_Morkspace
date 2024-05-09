package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	ReportService rServ = new ReportService();
	
	@GetMapping("/gen_report")
	public String genReport() {
		return "GenerateReport";
	}
	
	@PostMapping("/reportCardPdf")
	@ResponseBody
	public String generateReportCard(@RequestBody String data) {
		
		System.out.println(data);
		
		var document = new com.aspose.html.HTMLDocument(data, "D:/");
		document.save("D:/created.html");
		return data;
	}
	
	@GetMapping("/reportCard")
	@ResponseBody
	public String getReportCard(@RequestParam String name, 
			@RequestParam String roll_no) {
		System.out.println(name+" "+roll_no);
		
		int marks_id = rServ.getMarksId(name, roll_no);
		if(marks_id!=0) {
			System.out.println("Not a valid student");
		}
		return "abc";
	}
}
