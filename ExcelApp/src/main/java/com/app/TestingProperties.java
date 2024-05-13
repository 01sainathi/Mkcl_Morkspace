package com.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestingProperties {
	
	@Value("${lglobal.recordsPerPage}")
	private String globalRecordsPerPage;
	
	@Value("${QuestionPaperPath}")
	private String questionPaperPath;
	
	@Value("${ImagesPath}")
	private String imagesPath;
	
	@Value("${zipImagesPath}")
	private String zipImagesPath;
	
	@Value("${UserDefaultImagePath}")
	private String userDefaultImagePath;
	
	@Value("${CandidateStatisticsReportPath}")
	private String candidateStatisticsReportPath;
	
	@Value("${global.dateFormat}")
	private String globalDateFormat;
	
	@Value("${global.dateFormatWithoutTime}")
	private String globalDateFormatWithoutTime;
	
	@Value("${examClientVersion}")
	private String examClientVersion;
	
	@Value("${wkhtmltopdfPath}")
	private String wkhtmltopdfPath;
	
	@Value("${isCopyRightEnabled}")
	private String isCopyRightEnabled;
	
	@Value("${MaxCandidatesPerProctor}")
	private String maxCandidatesPerProctor;
	
	@Value("${isLoggingEnabled}")
	private String isLoggingEnabled;
	
	@Value("${isReportItemEnabled}")
	private String isReportItemEnabled;
	
	@GetMapping("/test/properties")
	public String test() {
		return "index";
	}
	
	@GetMapping("/get/properties")
	public String getProps(Model m) {
		System.out.println();
		m.addAttribute("globalRecordsPerPage", globalRecordsPerPage);
		m.addAttribute("questionPaperPath",questionPaperPath);
		m.addAttribute("candidateStatisticsReportPath", candidateStatisticsReportPath);
		m.addAttribute("imagesPath", imagesPath);
		m.addAttribute("zipImagesPath", zipImagesPath);
		m.addAttribute("userDefaultImagePath", userDefaultImagePath);
		m.addAttribute("globalDateFormat", globalDateFormat);
		
		m.addAttribute("globalDateFormatWithoutTime", globalDateFormatWithoutTime);
		m.addAttribute("examClientVersion", examClientVersion);
		m.addAttribute("wkhtmltopdfPath", wkhtmltopdfPath);
		m.addAttribute("isCopyRightEnabled", isCopyRightEnabled);
		m.addAttribute("maxCandidatesPerProctor", maxCandidatesPerProctor);
		m.addAttribute("isLoggingEnabled", isLoggingEnabled);
		m.addAttribute("isReportItemEnabled", isReportItemEnabled);
		return "properties";		
	}
}
