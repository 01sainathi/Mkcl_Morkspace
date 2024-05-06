package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.ExamEvent;
import com.app.service.HomeService;

@Controller
public class _TestController {
	
	HomeService hserv = new HomeService();
	
	@GetMapping("get/examEvent/json")
	@ResponseBody
	public ExamEvent getData() {
		return hserv.findById(165);
	}
}
