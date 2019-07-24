package com.IRCTC.cucumber.steps;

import com.IRCTC.pom.PageObjectManager;
import com.IRCTC.pom.webpages.HomePage;
import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.utilities.report.Report;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomeSteps extends StepManager {
    public RemoteWebDriver driver;
    public HomePage homePage;
    public ConfigTestData configTestData;
    PageObjectManager pageObjectManager;

    public HomeSteps(ConfigTestData configTestData) {
        this.configTestData = configTestData;
        pageObjectManager = new PageObjectManager(configTestData);
        this.driver = ConfigTestData.remoteDriver.get();
        homePage = pageObjectManager.getHomePage();

    }
    @Given("^user navigates to HomePage$")
    public void user_navigates_to_HomePage()  {
        Report.report(getStepName());
        homePage.navigateToHomePage();
    }

    @Then("^User Verifies Home Page is displayed$")
    public void verifyHomePageIsDisplayed()  {
        Report.verify(homePage.verifyPage(),getStepName());
    }

    @Then("^User clicks on Login$")
    public void User_clicks_on_Login()  {
        Report.report(getStepName());
        homePage.clickLogin();
    }

}
