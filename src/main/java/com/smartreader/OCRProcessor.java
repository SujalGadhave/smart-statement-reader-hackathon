package com.smartreader;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OCRProcessor {
    public static String performOCR(String filePath) throws TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("tessdata"); // Path to tessdata directory
        tesseract.setLanguage("eng");
        return tesseract.doOCR(new File(filePath));
    }
}

