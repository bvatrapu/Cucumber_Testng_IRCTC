package com.testautomation.framework.base;

import com.testautomation.framework.constatnts.GlobalConstants;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class TesseractExample {
    public static void main(String[] args) {
        String tessdataPath= GlobalConstants.workDir+ File.separator+"tessdata"+File.separator;
        File imageFile = new File(tessdataPath+"Captcha1.tif");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setDatapath(tessdataPath); // path to tessdata directory

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
