package com.IRCTC.cucumber.steps;

import com.IRCTC.pom.PageObjectManager;
import com.IRCTC.pom.webpages.HomePage;
import com.IRCTC.pom.webpages.LoginPage;
import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.utilities.report.Report;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginSteps extends StepManager {
    public RemoteWebDriver driver;
    public LoginPage loginPage;
    public ConfigTestData configTestData;
    PageObjectManager pageObjectManager;

    public LoginSteps(ConfigTestData configTestData) {
        this.configTestData = configTestData;
        pageObjectManager = new PageObjectManager(configTestData);
        this.driver = ConfigTestData.remoteDriver.get();
        loginPage = pageObjectManager.getLoginPage();
    }

    @Then("^Verify Login page is displayed$")
    public void Verify_Login_page_is_displayed()  {
        Report.verify(loginPage.verifyPage(),getStepName());
    }

    @Then("^Enter Username and password to login$")
    public void Enter_Username_and_password_to_login()  {
        loginPage.userLogin();
        Report.report(getStepName());
    }

    @Then("^Verify User Successfull login to Application$")
    public void Verify_User_Successfull_login_to_Application()  {
        Report.report(getStepName());
    }


}
