package com.IRCTC.pom.webpages;

import com.IRCTC.constants.ProjectConstants;
import com.IRCTC.constants.dataKey;
import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.constatnts.GlobalConstants;
import com.testautomation.framework.driverconfig.DriverBase;
import com.testautomation.framework.utilities.generator.ScreenshotGenarator;
import com.testautomation.framework.utilities.utils.ReadCaptcha;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverBase {
    private RemoteWebDriver driver=null;
    public LoginPage(ConfigTestData configTestData){
        super(configTestData);
        driver = ConfigTestData.remoteDriver.get();
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='modal-content']//h5[text()='Login']")
    public WebElement txtLoginHeader;

    @CacheLookup
    @FindBy(id = "userId")
    public WebElement inputUserName;

    @CacheLookup
    @FindBy(id = "pwd")
    public WebElement inputPassword;

    @CacheLookup
    @FindBy(xpath = "//div[@id='nlpImgContainer']//img[@id='captchaImg']")
    public WebElement imgCaptcha;

    @CacheLookup
    @FindBy(id = "nlpAnswer")
    public WebElement inputCaptch;

    @CacheLookup
    @FindBy(xpath = "//li/a[@class='nlpRefresh']")
    public WebElement btnRefresh;

    @CacheLookup
    @FindBy(xpath = "//div[@class='modal-content']//button[text()='SIGN IN']")
    public WebElement btnSignIn;

    public boolean verifyPage(){
        boolean status=true;
        if(!isExist(txtLoginHeader)){
            status=false;
        }
        return status;
    }
    public void userLogin(String username,String password){
        sendKeys(inputUserName,username);
        sendKeys(inputPassword,password);
        String strCaptch = ReadCaptcha.readCaptcha(imgCaptcha);
        sendKeys(inputCaptch,strCaptch);
        click_JavaScript(btnSignIn);
    }

    public void userLogin(){
        sendKeys(inputUserName,readTestdata(dataKey.HomePage_UserName.getPage()));
        sendKeys(inputPassword,dataKey.HomePage_Password.getPage());
        click_JavaScript(btnRefresh);
        sleep(5);
        String strCaptch = ReadCaptcha.readCaptcha(imgCaptcha);
        String captch[] = null;
        captch = strCaptch.split("below:");

        System.out.println("String captcha::>>"+strCaptch);
        System.out.println("captcha::>>"+captch[1].trim());

        sendKeys(inputCaptch,captch[1].trim());
        click_JavaScript(btnSignIn);
        sleep(60);
    }
}
