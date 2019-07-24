package com.testautomation.framework.base;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.File;

/**
 * @Author Bharath Kumar Reddy V
 * @Date 10-June-2019
 */

public class ConfigTestData {

    // Config Properties
    public static String localGridHub = null;
    public static String seleniumGridPath = null;
    public static String mobile_cloud_private_url = null;
    public static String mobile_cloud_public_url = null;
    public static String mobile_cloud_env = null;
    public static String mobile_cloud_private_userid = null;
    public static String mobile_cloud_private_password = null;
    public static String mobile_cloud_public_userid = null;
    public static String mobile_cloud_public_password = null;

    public static String mobile_app_path = null;
    public static String mobile_device_cloud_public_path = null;
    public static String mobile_device_cloud_private_path = null;
    public static String mobile_device_local_path = null;



    // Testng params
    public String testEnvironment = null;
    public String testservice = null;
    public String testPlatform = null;
    public String testBrowser = null;
    public String testDeviceName = null;
    public String testAppName = null;
    public String testNetowk = null;


    public String groupName = null;
    // Mobile Capabilities Testng params
    public String mb_cloud_env =null;
    public String mb_udid = null;
    public String mb_deviceName = null;
    public String mb_platformName = null;
    public String mb_platformVersion = null;
    public String mb_manufacturer = null;

    public String mb_appPackage = null;
    public String mb_appActivity = null;

    public String testMethodName = null;

    // Remote we driver
    public static ThreadLocal<RemoteWebDriver> remoteDriver = null;
    public RemoteWebDriver mobileWebDriver = null;
    public RemoteWebDriver chromeDriver = null;
    public RemoteWebDriver firefoxDriver = null;
    public RemoteWebDriver internerExplorerDriver = null;
    public RemoteWebDriver safariDriver = null;
    public RemoteWebDriver edgeDriver = null;
    public RemoteWebDriver operaDriver = null;

    public AppiumDriver androidDriver = null;
    public AppiumDriver iOSDriver = null;
    public WiniumDriver winDriver = null;



    public String TEST_DATA_FILE_PATH = null;


    public Status finalTestCaseStatus = Status.PASS;

    public String suiteXmlName=null;

    public int stepNo =  0;

    public static String PROJECT_NAME = null;



}
