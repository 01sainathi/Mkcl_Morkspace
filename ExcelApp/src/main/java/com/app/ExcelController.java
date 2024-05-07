package com.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.service.ExcelService;

@Controller
public class ExcelController {
	
	private ExcelService eServ = new ExcelService();
	
	
	@GetMapping("/createExcel")
	public String create() {
		return "CreateExcel";
	}
	@GetMapping("/readExcel")
	public String read() {
		return "ReadExcel";
	}
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
		
		String path = "D:/ExcelFiles/"+file.getOriginalFilename();
		System.out.println("----------------------->"+path);
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			
			eServ.readExcelAndSaveInDB(path);
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
	
	@PostMapping("/downloadExcel")
	public void createExcelFromData(@RequestParam("inputText") String inputText,
			HttpServletResponse response) {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("data");
		
		String[] lines = inputText.split("\\r?\\n");
		int numberOfColumns = lines[0].split(",").length;
		int rowNum = 0;
		
		// Define cell style for the header row

		CellStyle headerCellStyle = wb.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short)14);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		// Create the header row which is merged across three columns

		Row headerRow = sheet.createRow(rowNum++);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("User Information");
		headerCell.setCellStyle(headerCellStyle);
		
		//(0, 0, 0, 2) specifies the range of cells from A1 to C1
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,numberOfColumns-1));
		//(0,0)1st row 1st col top left to (0,2)1st row 2nd col ie top right

		//Create the column headers
		Row columnHeaderRow = sheet.createRow(rowNum++);
		String[] columnHeaders = lines[0].split(",");
		int colNum = 0;
		for(String columnHeader: columnHeaders) {
			Cell columnHeaderCell = columnHeaderRow.createCell(colNum++);
			columnHeaderCell.setCellValue(columnHeader);
			columnHeaderCell.setCellStyle(headerCellStyle);
		}
		
		// Define cell style for data cells
        CellStyle dataCellStyle = wb.createCellStyle();
        dataCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        dataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        dataCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        dataCellStyle.setBorderLeft(BorderStyle.MEDIUM);
        dataCellStyle.setBorderRight(BorderStyle.MEDIUM);
        dataCellStyle.setBorderTop(BorderStyle.MEDIUM);
        
        
        //Add data to the sheet 
        for(int i=1; i<lines.length; i++) {
        	String line = lines[i];
        	Row row = sheet.createRow(rowNum++);
        	String[] columns = line.split(",");
        	colNum=0;
        	for(String column: columns) {
        		Cell cell = row.createCell(colNum++);
        		cell.setCellValue(column);
        		cell.setCellStyle(dataCellStyle);
        	}
        }
        
        //Set response headers
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition",  "attachment; filename=data.xlsx");
        
        //Write workbook to response output stream
        try {
			wb.write(response.getOutputStream());
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

