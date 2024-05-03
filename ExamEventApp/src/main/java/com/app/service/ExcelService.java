package com.app.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.app.daos.ExcelDao;
import com.app.models.ExamEvent;

public class ExcelService {
	
	private ExcelDao eDao = new ExcelDao();
	
	public String readExcelAndSaveInDB(String path, String SheetName) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet s = wb.getSheet(SheetName);
			
			List<ExamEvent> list = new ArrayList<>();
			for(int i=2; i<8; i++) {
				ExamEvent e = new ExamEvent();
				for(int j=0; j<3; j++) {
					Row r = s.getRow(i);
					Cell c = r.getCell(j);
					String data = c.getStringCellValue();
					
					if(j==0) {
						e.setName(data);
					}
					else if(j==1) {
						e.setExamEventCode(data);
					}
					else if(j==2) {
						e.setDefaultLanguageID(data);
					}
				}
				list.add(e);
				
			}
			
			return eDao.save(list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "something wrong";
	}
}
