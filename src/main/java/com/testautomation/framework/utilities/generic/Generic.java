package com.testautomation.framework.utilities.generic;

import com.testautomation.framework.base.ConfigBase;
import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.constatnts.GlobalConstants;
import com.testautomation.framework.utilities.report.Log;
import com.testautomation.framework.utilities.utils.JsonUtils;
import org.openqa.selenium.Platform;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Generic {

    static ResourceBundle rbConfig =null;

    private static Platform platform = null;
    ConfigTestData configTestData=null;
    JsonUtils jsonUtils=null;

    public Generic(ConfigTestData configTestData){
        this.configTestData=configTestData;
        jsonUtils = new JsonUtils();
    }


    /*	To get the host OS name */
    public static Platform getCurretnPlatform(){
        if(platform == null){
            String osname = System.getProperty("os.name").toLowerCase();
            if(osname.contains("win")){
                platform = Platform.WINDOWS;
            } else if(osname.contains("nix") || osname.contains("nux") || osname.contains("aix")){
                platform=Platform.LINUX;
            } else if(osname.contains("mac")){
                platform=Platform.MAC;
            }
        }

        return platform;
    }

    /*	To get the ComputerName */
    public static String getComputerName() throws Exception{
        String hostname = "Unknown";
        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex) {
            ex.fillInStackTrace();
            System.out.println("Hostname can not be resolved");
        }
        return (hostname);
    }
    /**
     * Method Description :: Verify Text actual and expected
     * @param sActualText
     * @param sExpectedText
     * @param verifyTextOptions
     * @return
     */
    public static boolean verifyText(String sActualText, String sExpectedText, String verifyTextOptions){
        boolean result=true;
        try{
            switch (verifyTextOptions) {
                case "EXACTMATCH":
                    result = sActualText.equals(sExpectedText);
                    break;
                case "EXACTMATCHIGNORECASE":
                    sActualText=sActualText.trim();
                    sExpectedText=sExpectedText.trim();
                    result=sActualText.equalsIgnoreCase(sExpectedText);
                    break;
                case "PARTIAL":
                    sActualText=sActualText.trim().toLowerCase();
                    sExpectedText=sExpectedText.trim().toLowerCase();
                    result = sActualText.contains(sExpectedText);
                    break;
            }

        }catch (Exception e) {
            result=false;
            Log.error("Exception in verifyText :"+ e.getMessage());
        }
        return result;
    }


    public String readFile(String filepath) throws IOException{
        File file = new File(filepath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while(line!=null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();

        } finally {
            bufferedReader.close();
        }
    }

    public String getSuiteXmlGroupName(String[] groupnames){
        String groupName=null;
        for(int i=0;i<=groupnames.length-1;i++){
            groupName = groupnames[0];
        }
        return groupName;

    }
    public void readMobileCapabilities(String mobileName){
        ClassLoader loader=null;
        String path=null;
        try {
            if(configTestData.testNetowk.contains("cloud")){
                if(ConfigTestData.mobile_cloud_env.equalsIgnoreCase("public")){
                    path=GlobalConstants.workDir+ File.separator + ConfigTestData.mobile_device_cloud_public_path;
                } else{
                    path=GlobalConstants.workDir+ File.separator + ConfigTestData.mobile_device_cloud_private_path;
                }
            } else{
                path=GlobalConstants.workDir+ File.separator + ConfigTestData.mobile_device_local_path;
            }
            File file = new File(path);
            URL[] urls = {file.toURI().toURL()};
            loader = new URLClassLoader(urls);
        }catch (Exception e){
            e.printStackTrace();
        }
        ResourceBundle rbTestdata = ResourceBundle.getBundle(mobileName, Locale.getDefault(), loader);
        configTestData.mb_udid = rbTestdata.getString("UDID");
        configTestData.mb_deviceName= rbTestdata.getString("DeviceName");
        configTestData.mb_platformName = rbTestdata.getString("PlatformName");
        configTestData.mb_platformVersion = rbTestdata.getString("PlatformVersion");
//        configTestData.mb_manufacturer = rbTestdata.getString("Manufacturer");

    }
    public void readMobileAppCapabilities(String appName){
        ClassLoader loader=null;
        String path=GlobalConstants.workDir+ File.separator + ConfigTestData.mobile_app_path;
        try {

            System.out.println("path::"+path);
            File file = new File(path);
            URL[] urls = {file.toURI().toURL()};
            loader = new URLClassLoader(urls);
        }catch (Exception e){
            e.printStackTrace();
        }
        ResourceBundle rbTestdata = ResourceBundle.getBundle(appName, Locale.getDefault(), loader);

        configTestData.mb_appPackage = rbTestdata.getString("AppPackage");
        configTestData.mb_appActivity = rbTestdata.getString("AppActivity");
    }

    public static String getTestDataPath(@Nullable String strTemp){
        if(strTemp==null){
            return MessageFormat.format(readConfigProp("testdata.path"),GlobalConstants.workDir);
        } else {
            return MessageFormat.format(readConfigProp("testdata.path"), GlobalConstants.workDir, strTemp);
        }
    }

    // Load the Config properties file from test source
    public static void loadConfigProp() throws Exception{
        File file = new File(GlobalConstants.CONFIG_PROP_FILE_PATH);
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        rbConfig = ResourceBundle.getBundle("config", Locale.getDefault(), loader);
    }
    // Read the Config properties file from test source
    public static String readConfigProp(String key){

        try {
            loadConfigProp();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rbConfig.getString(key);
    }
    // Read the Config properties file from test source
    public static void readConfigProp(){
        ClassLoader loader=null;
        String path=null;
        try {

            File file = new File(GlobalConstants.CONFIG_PROP_FILE_PATH);
            URL[] urls = {file.toURI().toURL()};
            loader = new URLClassLoader(urls);
        }catch (Exception e){
            e.printStackTrace();
        }
        ResourceBundle rbTestdata = ResourceBundle.getBundle("config", Locale.getDefault(), loader);
        ConfigTestData.localGridHub = rbTestdata.getString("localGridHub");
        ConfigTestData.seleniumGridPath = rbTestdata.getString("seleniumGridPath");
        ConfigTestData.mobile_cloud_private_url = rbTestdata.getString("mobile.cloud.private.url");
        ConfigTestData.mobile_cloud_public_url = rbTestdata.getString("mobile.cloud.public.url");
        ConfigTestData.mobile_cloud_env = rbTestdata.getString("mobile.cloud.env");
        ConfigTestData.mobile_cloud_private_userid = rbTestdata.getString("mobile.cloud.private.userid");
        ConfigTestData.mobile_cloud_private_password = rbTestdata.getString("mobile.cloud.private.password");
        ConfigTestData.mobile_cloud_public_userid = rbTestdata.getString("mobile.cloud.public.userid");
        ConfigTestData.mobile_cloud_public_password = rbTestdata.getString("mobile.cloud.public.password");

        ConfigTestData.mobile_app_path = rbTestdata.getString("mobile.app.path");
        ConfigTestData.mobile_device_cloud_public_path = rbTestdata.getString("mobile.device.cloud.public.path");
        ConfigTestData.mobile_device_cloud_private_path = rbTestdata.getString("mobile.device.cloud.private.path");
        ConfigTestData.mobile_device_local_path = rbTestdata.getString("mobile.device.local.path");
        ConfigTestData.PROJECT_NAME = rbTestdata.getString("project.name");
        GlobalConstants.CAPTCHA_PATH = rbTestdata.getString("captcha.tessdata.path");
    }

}
