package com.testautomation.framework.driverconfig.driverbase;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import java.net.MalformedURLException;

public interface Winium<S extends WiniumDriver,T extends DesktopOptions,W extends WiniumDriverService> {

  S buildWiniumDriver(T options, W services) throws MalformedURLException;

}
