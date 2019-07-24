package com.IRCTC.pom;

import com.IRCTC.pom.webpages.HomePage;
import com.IRCTC.pom.webpages.LoginPage;
import com.testautomation.framework.base.ConfigTestData;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageObjectManager {
    private RemoteWebDriver driver;
    private ConfigTestData configTestData;
    private HomePage homePage;
    private LoginPage loginPage;

    public PageObjectManager(ConfigTestData configTestData){
        this.driver= ConfigTestData.remoteDriver.get();
        this.configTestData=configTestData;
    }

    public HomePage getHomePage(){
        return (homePage==null)?homePage=new HomePage(configTestData):homePage;
    }

    public LoginPage getLoginPage(){
        return (loginPage==null)?loginPage=new LoginPage(configTestData):loginPage;
    }

}
