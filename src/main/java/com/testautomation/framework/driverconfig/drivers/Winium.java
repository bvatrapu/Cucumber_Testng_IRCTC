package com.testautomation.framework.driverconfig.drivers;

import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.driverconfig.driverbase.BaseWiniumDriver;
import com.testautomation.framework.utilities.generic.Generic;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import java.io.File;
import java.net.MalformedURLException;

public class Winium extends BaseWiniumDriver<WiniumDriver, DesktopOptions,WiniumDriverService, Winium> {
    private ConfigTestData configTestData=null;
    static WiniumDriverService service = null;
    static DesktopOptions options = null;
    public Winium(ConfigTestData configTestData) {
        this.configTestData = configTestData;
    }

    @Override
    protected Winium setDriverPath() {
        System.setProperty("webdriver.winium.desktop.driver", Generic.readConfigProp("seleniumGridPath")+File.separator+"DRIVERS"+File.separator+"Winium.Desktop.Driver.exe");
        return this;
    }
    @Override
    public DesktopOptions getDefaultOptions() {
        options = new DesktopOptions();
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
        return options;
    }

    protected DesktopOptions getOptions(DesktopOptions desktopOptions) {
        return desktopOptions == null ? getDefaultOptions() : desktopOptions;
    }
    @Override
    public WiniumDriverService getDefaultServices() {
        File driverPath = new File(Generic.readConfigProp("seleniumGridPath")+File.separator+"DRIVERS"+File.separator+"Winium.Desktop.Driver.exe");
        service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
                .withSilent(false).buildDesktopService();
        return service;
    }

    protected WiniumDriverService getServices(WiniumDriverService winiumDriverService) {
        return winiumDriverService == null ? getDefaultServices() : winiumDriverService;
    }

    @Override
    public WiniumDriver buildWiniumDriver(DesktopOptions desktopOptions,WiniumDriverService winiumDriverService)
            throws MalformedURLException {
       // configTestData.winDriver = setWindowAppDriverManage(new WiniumDriver(getServices(winiumDriverService),getOptions(desktopOptions)));

        configTestData.winDriver = new WiniumDriver(getServices(winiumDriverService),getOptions(desktopOptions));
        return configTestData.winDriver;
    }

}
