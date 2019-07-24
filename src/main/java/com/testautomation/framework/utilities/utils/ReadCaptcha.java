package com.testautomation.framework.utilities.utils;

import com.testautomation.framework.base.ConfigBase;
import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.constatnts.GlobalConstants;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

public class ReadCaptcha {
    static RemoteWebDriver driver;
    public static void main(String[] args) {
        String tessdataPath= GlobalConstants.workDir+ File.separator+"tessdata"+File.separator;
       // File imageFile = new File(tessdataPath+"Captcha1.tif");
        File imageFile = new File(tessdataPath+"logo-image.tif");
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
    public static String readCaptcha(WebElement element){
        driver = ConfigTestData.remoteDriver.get();
        String logoSRC = element.getAttribute("src");

        String result=null;
        String tessdataPath= GlobalConstants.workDir+File.separator+ GlobalConstants.CAPTCHA_PATH +File.separator;
        ///AShot shot = new AShot();
        System.out.println("Driver::"+ConfigTestData.remoteDriver.get());
        System.out.println("tessdataPath::"+tessdataPath);
       // Screenshot screenshot = shot.takeScreenshot(ConfigTestData.remoteDriver.get(),element);
      //  BufferedImage imgCaptcha = screenshot.getImage();
        ITesseract instance = new Tesseract();
        instance.setDatapath(tessdataPath);

        try {
            URL imageURL = new URL(logoSRC);
            BufferedImage saveImage = ImageIO.read(imageURL);
            File img=new File(tessdataPath+"captcha.tif");
            ImageIO.write(saveImage, "tif", img);


            result = instance.doOCR(img);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
