package com.IRCTC.pom.webpages;

import com.IRCTC.constants.dataKey;
import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.driverconfig.DriverBase;
import com.testautomation.framework.utilities.report.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverBase {
    private RemoteWebDriver driver=null;
    public PageObjects pageObjects;
    public HomePage(ConfigTestData configTestData){
        super(configTestData);
        driver = ConfigTestData.remoteDriver.get();
        pageObjects = new PageObjects();
        PageFactory.initElements(driver,pageObjects);
    }





    public void navigateToHomePage(){
        try{
            System.out.println("homepage::"+dataKey.HomePage.getPage());
           navigateToUrl(readTestdata(dataKey.HomePage.getPage()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean verifyPage() {
        boolean status=true;
        if(!driver.getCurrentUrl().contains(readTestdata(dataKey.HomePage.getPage()))){
            status=false;
        }
        return status;
    }

    public void clickLogin(){
        click_JavaScript(pageObjects.hamburger);
        waitForClickability(pageObjects.btnLogin,20);
        if(isExist(pageObjects.btnLogin)){
            click_JavaScript(pageObjects.btnLogin);
        } else{
            Log.error("Login button is not displayed::"+pageObjects.btnLogin);
        }
    }


    class PageObjects{

        @CacheLookup
        @FindBy(xpath = "//div[@class='h_menu_drop_button hidden-xs']/a")
        public WebElement hamburger;

        @CacheLookup
        @FindBy(xpath = "//p-sidebar//label/button[text()='LOGIN']")
        public WebElement btnLogin;
    }
}
