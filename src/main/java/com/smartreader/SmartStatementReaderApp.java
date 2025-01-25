package com.smartreader;

import net.sourceforge.tess4j.TesseractException;

import java.io.IOException;

public class SmartStatementReaderApp {
    public static void main(String[] args) throws IOException, TesseractException {
        String filePath = "path/to/your/pdf.pdf";
        try {
            // Step 1: Extract Text
            String extractedText = PDFProcessor.extractTextFromPDF(filePath);
            System.out.println("Extracted Text: \n" + extractedText);

            // Step 2: Perform OCR if needed
            if (extractedText.trim().isEmpty()) {
                extractedText = OCRProcessor.performOCR(filePath);
                System.out.println("OCR Text: \n" + extractedText);
            }

            // Step 3: AI Model Classification
            String format = AIModelProcessor.classifyPDF(filePath);
            System.out.println("Detected Format: " + format);

            // Step 4: Export to Excel
            String[][] sampleData = {{"Date", "Amount", "Description"}, {"2025-01-01", "1000", "Invoice Payment"}};
            ExportToExcel.writeToExcel(sampleData, "output.xlsx");
            System.out.println("Data exported to Excel.");

            // Step 5: Feedback
            FeedbackProcessor.saveFeedback("The extraction was accurate.", "feedback.txt");
            System.out.println("Feedback saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

