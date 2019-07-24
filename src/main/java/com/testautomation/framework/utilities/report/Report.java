package com.testautomation.framework.utilities.report;

import com.aventstack.extentreports.Status;
import com.testautomation.framework.base.ConfigBase;
import com.testautomation.framework.base.ConfigTestData;
import org.testng.Assert;

public class Report {
    private static ConfigTestData configTestData;
    private static ExtentManager extentManager;

    public Report(ConfigTestData configTestData,ExtentManager extentManager){
        this.configTestData=configTestData;
        this.extentManager=extentManager;
    }
    public static void Assert(boolean condition,String message){
        configTestData.stepNo = configTestData.stepNo+1;
        if(condition){
            extentManager.addExecutionStep(Status.PASS,message);
        } else{
            extentManager.addExecutionStep(Status.FAIL,message);
            configTestData.finalTestCaseStatus = Status.FAIL;
        }
        Assert.assertTrue(condition,message);
    }

    public static void verify(boolean condition, String message){
        configTestData.stepNo = configTestData.stepNo+1;
        if(condition){
            extentManager.addExecutionStep(Status.PASS,message);
        } else{
            extentManager.addExecutionStep(Status.FAIL,message);
            configTestData.finalTestCaseStatus = Status.FAIL;
        }
    }

    public static void report(String message){
        configTestData.stepNo = configTestData.stepNo+1;
        extentManager.addExecutionStep(Status.INFO,message);
    }
}
