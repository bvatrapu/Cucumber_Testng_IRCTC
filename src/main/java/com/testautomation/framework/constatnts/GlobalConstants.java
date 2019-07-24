package com.testautomation.framework.constatnts;

import com.testautomation.framework.utilities.generic.Generic;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;

/**
 * @Author Bharath Kumar Reddy V
 * @Date 10-June-2019
 */
public class GlobalConstants {

    public static String workDir = System.getProperty("user.dir");
    public static String CONFIG_PROP_FILE_PATH = workDir+ File.separator+"src"+File.separator+"test"+File.separator+"resources";
    public static String REPORTS_PATH = workDir +File.separator+ Generic.readConfigProp("reports.path");
   // public static RemoteWebDriver driver = null;

    public static String C_CHECK = "CHECK";
    public static String C_UNCHECK = "UNCHECK";
    public static String C_ALERT_ACCEPT = "ACCEPT";
    public static String C_ALERT_DECLINE = "DECLINE";

    public static String VERIFY_TEXT_EXACTMATCH = "EXACTMATCH";
    public static String VERIFY_TEXT_EXACTMATCHIGNORECASE = "EXACTMATCHIGNORECASE";
    public static String VERIFY_TEXT_PARTIAL = "PARTIAL";

    public static final int SHORT_TIMEOUT = 5;
    public static final int MEDIUM_TIMEOUT = 10;
    public static final int LONG_TIMEOUT = 20;

    public static boolean HUB_STATUS = false;
    public static boolean NODE_STATUS = false;

    public static String CAPTCHA_PATH = null;
}
