package com.testautomation.framework.utilities.generator;

import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.constatnts.GlobalConstants;
import com.testautomation.framework.utilities.generic.Generic;
import com.testautomation.framework.utilities.utils.DateUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;

public class ScreenshotGenarator {

    static ConfigTestData configTestData=null;

    public ScreenshotGenarator(ConfigTestData configTestData){
        this.configTestData=configTestData;

    }
    public static String getScreenshot(String path) throws FileNotFoundException {
        String screenshotPath = null;

        if(path == null) {
            String screenshotFileName = configTestData.testMethodName + "_[" + DateUtils.getTime() + "]_" + DateUtils.getDate();
            screenshotPath = Generic.readConfigProp("reports.screenshots.path") + screenshotFileName + ".png";
            path = GlobalConstants.workDir+Generic.readConfigProp("reports.path") + screenshotPath;

        }

        File file = new File(path);
        path = screenshotPath;

        byte[] screenshot = new byte[0];

        AShot shot = new AShot();
        shot = shot.shootingStrategy(ShootingStrategies.viewportPasting(100));
        Screenshot screen = shot.takeScreenshot(ConfigTestData.remoteDriver.get());
        BufferedImage originalImage = screen.getImage();

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "png", baos);
            baos.flush();
            screenshot = baos.toByteArray();
            baos.close();
            InputStream in = new ByteArrayInputStream(screenshot);

            BufferedImage image = ImageIO.read(in);

            ImageIO.write(image, "png", file);
        } catch (Exception noScreenshot) {
        }
        return path;
    }

    public static String getScreenshotOfWebElement(WebElement element,String imgPath){
        String imgName = "img_"+DateUtils.getTime()+"_"+DateUtils.getDate()+".png";
        imgPath = imgPath+File.separator+imgName;
        AShot shot = new AShot();
        Screenshot screenshot = shot.takeScreenshot(ConfigTestData.remoteDriver.get(),element);

        System.out.println("Image Path::"+imgPath);
        try {
            ImageIO.write(screenshot.getImage(),"PNG",new File(imgPath));
        } catch (Exception e) {
        }
        return imgPath;
    }

    public boolean imageComparison(WebElement element,String strImagePath){
        boolean status=true;
        try {
            BufferedImage expectedImage = ImageIO.read(new File(strImagePath));
            Screenshot imageScreenshot = new AShot().takeScreenshot(ConfigTestData.remoteDriver.get(),element);
            BufferedImage actualimage = imageScreenshot.getImage();

            ImageDiffer imageDiffer=new ImageDiffer();
            ImageDiff imageDiff=imageDiffer.makeDiff(expectedImage,actualimage);
            status=imageDiff.hasDiff();
        }catch (Exception e) {
        }
        return status;
    }
}
