package com.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.service._ExcelService;

@Controller
public class _ExcelController {
	
	private _ExcelService eServ = new _ExcelService();
	
	
	@PostMapping("excel/save")
	@ResponseBody
	public String saveExcelFile(@RequestParam("excel") CommonsMultipartFile file, HttpSession s) {
		System.out.println("----------------------->"+file.getName());
		System.out.println("----------------------->"+file.getOriginalFilename());
		System.out.println("----------------------->"+file.getSize());
		System.out.println("----------------------->"+file.getContentType());
		System.out.println("----------------------->"+file.getStorageDescription());
		
		byte[] data = file.getBytes();
		//we have to save this file to server...
		
		String path = s.getServletContext().getRealPath("/Files/")+file.getOriginalFilename();
		System.out.println("----------------------->"+path);
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			
			eServ.readExcelAndSaveInDB(path, "Sheet1");
			return "File Saved";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "file not found";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "IOException";
		}
		
	}
}
