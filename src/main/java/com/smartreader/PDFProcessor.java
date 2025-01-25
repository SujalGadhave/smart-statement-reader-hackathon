package com.smartreader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
public class PDFProcessor {

	public static String extractTextFromPDF(String filePath) throws IOException {
		filePath = "C:/Users/admin/Documents/bankStatement.pdf";
		try (PDDocument document = PDDocument.load(new File(filePath))) {
	            PDFTextStripper stripper = new PDFTextStripper();
	            return stripper.getText(document);
	    }
	}
}

