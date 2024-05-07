package com.app.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.app.model.ExamEvent;

public class PdfService {
	public byte[] generatePDF(ExamEvent e) {
		try (PDDocument doc = new PDDocument()) {
			PDPage page = new PDPage();
			doc.addPage(page);
			try (PDPageContentStream contentStream = new PDPageContentStream(doc, page)) {
				contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
				contentStream.beginText();
				contentStream.newLineAtOffset(50, 750);
				contentStream.newLine();
				contentStream.showText("Exam Event Information");
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				contentStream.showText("ID: " + e.getExamEventID());
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				contentStream.showText("Name: " + e.getName());
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				contentStream.showText("Exam event Code: " + e.getExamEventCode());
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				contentStream.showText("Default language: " + e.getDefaultLanguageID());
				contentStream.endText();
			}
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			doc.save(byteArrayOutputStream);

			return byteArrayOutputStream.toByteArray();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public byte[] generatePDFOutOfList(List<ExamEvent> list) {
		try (PDDocument doc = new PDDocument()) {
			PDPage page = null;
			PDPageContentStream contentStream = null;
			for (int i = 0; i < list.size(); i++) {
				if (i % 5 == 0) {
					page = new PDPage();
					doc.addPage(page);
					if (i > 0) {
						contentStream.close();
					}
					contentStream = new PDPageContentStream(doc, page);
					contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
					contentStream.beginText();
					contentStream.newLineAtOffset(50, 750);
					contentStream.newLine();
					contentStream.showText("Exam Event Information");
					contentStream.newLineAtOffset(0, -20);
				}
				ExamEvent e = list.get(i);
				System.out.println(e);
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				contentStream.showText("ID: " + e.getExamEventID());
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				contentStream.showText("Name: " + e.getName());
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				contentStream.showText("Exam event Code: " + e.getExamEventCode());
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				contentStream.showText("Default language: " + e.getDefaultLanguageID());
				contentStream.newLineAtOffset(0, -20);
			}
			contentStream.endText();
			contentStream.close();

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			doc.save(byteArrayOutputStream);

			return byteArrayOutputStream.toByteArray();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
