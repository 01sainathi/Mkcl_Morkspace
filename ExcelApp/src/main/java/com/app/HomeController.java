package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@GetMapping("/")
	public String index() {
		 logger.trace("1. This is the trace message from the home controller");
         logger.debug("2. This is the debug message from the home controller");
         logger.info("1. This is the info message from the home controller");
         logger.warn("1. This is the warn message from the home controller");
         logger.error("1. This is the error message from the home controller");
     
		return "index";
	}
}
