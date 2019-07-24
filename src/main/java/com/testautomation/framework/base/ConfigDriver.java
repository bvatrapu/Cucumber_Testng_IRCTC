package com.testautomation.framework.base;

import com.testautomation.framework.constatnts.GlobalConstants;
import com.testautomation.framework.driverconfig.driverbase.MobileDriver;
import com.testautomation.framework.driverconfig.driverbase.WebDriver;
import com.testautomation.framework.driverconfig.drivers.*;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nullable;
import java.net.MalformedURLException;

/**
 * @Author Bharath Kumar Reddy V
 * @Date 10-June-2019
 */

public class ConfigDriver {

    private ConfigTestData configTestData=null;
    public ConfigDriver(ConfigTestData configTestData) {
        this.configTestData = configTestData;
    }

    public void initDriver() throws Exception {
        if(configTestData.testPlatform.equalsIgnoreCase("desktop")){
            ConfigTestData.remoteDriver.set(getWebDriver(null));
           // GlobalConstants.driver = getWebDriver(null);
        } else if(configTestData.testPlatform.equalsIgnoreCase("mobile")) {
            if(configTestData.testservice.equalsIgnoreCase("WEB")){
                ConfigTestData.remoteDriver.set(getWebDriver(null));
               // GlobalConstants.driver =  getWebDriver(null);
            } else {
                ConfigTestData.remoteDriver.set(getMobileDriver(null));
                //GlobalConstants.driver = getMobileDriver(null);
            }
        }
    }

    public AppiumDriver getMobileDriver(@Nullable Capabilities capabilities)throws MalformedURLException {
        MobileDriver mobileDriver = null;
        switch (configTestData.mb_platformName.toLowerCase()) {
            case "android":
                mobileDriver  = new Android(configTestData);
                break;
            case "ios":
                mobileDriver  = new IOS(configTestData);
                break;
        }
        return mobileDriver.buildMobileDriver(capabilities);
    }
    public RemoteWebDriver getWebDriver(@Nullable Capabilities capabilities)
            throws MalformedURLException {
        WebDriver webDriver = null;

        switch (configTestData.testBrowser) {
            case "firefox":
            case "ff":
                webDriver = new FirefoxBrowser(configTestData);
                break;
            case "chrome":
            case "incognito":
                webDriver = new ChromeBrowser(configTestData);
                break;
            case "ie":
            case "internet explorer":
            case "ie11":
                webDriver = new IE11Browser(configTestData) ;
                break;
            case "safari":
                webDriver = new SafariBrowser(configTestData) ;
                break;
            case "edge":
            case "microsoft edge":
                webDriver = new EdgeBrowser(configTestData);
                break;
            case "opera":
                webDriver = new OperaBrowser(configTestData) ;
                break;
            default:
                webDriver = new MobileBrowser(configTestData);
                break;
        }
        return webDriver.buildWebDriver(capabilities);
    }

}
