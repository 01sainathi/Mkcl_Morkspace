package com.app.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.app.dao.ExcelDao;
import com.app.model.ExamEvent;

public class ExcelService {
	
	private ExcelDao eDao = new ExcelDao();
	
	public String readExcelAndSaveInDB(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			
			List<ExamEvent> list = new ArrayList<>();
			
			int noOfSheets = wb.getNumberOfSheets();
			
			for(int k=0; k<noOfSheets; k++) {
				Sheet s = wb.getSheetAt(k);
				int row = s.getLastRowNum()+1;
				int col = s.getRow(2).getLastCellNum();
				System.out.println("Number of rows--------------------->"+row);
				System.out.println("Number of cols--------------------->"+col);		
				
				for(int i=1; i<row; i++) {
					ExamEvent e = new ExamEvent();
					for(int j=0; j<col; j++) {
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
			}
			System.out.println("---------------------------->"+list);
//			return "";
			return eDao.save(list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "something wrong";
	}
	
	public List<ExamEvent> readExcel(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			
			List<ExamEvent> list = new ArrayList<>();
			
			int noOfSheets = wb.getNumberOfSheets();
			
			for(int k=0; k<noOfSheets; k++) {
				Sheet s = wb.getSheetAt(k);
				int row = s.getLastRowNum()+1;
				int col = s.getRow(2).getLastCellNum();
				System.out.println("Number of rows--------------------->"+row);
				System.out.println("Number of cols--------------------->"+col);		
				
				for(int i=1; i<row; i++) {
					ExamEvent e = new ExamEvent();
					for(int j=0; j<col; j++) {
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
			}
			System.out.println("---------------------------->"+list);
//			return "";
			return list;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
