package com.IRCTC.base;

import com.testautomation.framework.base.ConfigBase;
import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.utilities.generic.Generic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestBase extends ConfigBase {


    @Parameters()
    @BeforeMethod(alwaysRun = true)
    public void initWebBrowserSetup() throws Exception {
        System.out.println("Projcectname::"+ ConfigTestData.PROJECT_NAME);
        loadTestData(ConfigTestData.PROJECT_NAME,configTestData.testEnvironment);
    }
    public static ResourceBundle loadTestData(String tdpath, String env){
        ClassLoader loader=null;
        System.out.println("Path::::"+env);
        try {
            File file = new File(Generic.getTestDataPath(tdpath));
            URL[] urls = {file.toURI().toURL()};
            loader = new URLClassLoader(urls);
        }catch (Exception e){
            e.printStackTrace();
        }

        return rbTestdata = ResourceBundle.getBundle(env, Locale.getDefault(), loader);
    }
}
