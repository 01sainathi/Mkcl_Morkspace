package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel {
	public static void main(String[] args) {
		ReadExcel obj = new ReadExcel();
		
		for(int i=2; i<5; i++) {
			String name = obj.readExcel("Sheet1", i, 0);
			String roll = obj.readExcel("Sheet1", i, 1);
			System.out.println("First Name:- "+name);
			System.out.println("Last Name:- "+roll);
		}
	}
	
	public String readExcel(String SheetName, int rNum, int cNum) {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\sainathi\\Downloads\\Excel Files\\Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet s = wb.getSheet(SheetName);
			Row r = s.getRow(rNum);
			Cell c = r.getCell(cNum);
			String data = c.getStringCellValue();
			return data;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}
