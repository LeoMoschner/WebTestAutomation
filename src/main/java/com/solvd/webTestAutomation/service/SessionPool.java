package com.solvd.webTestAutomation.service;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
public class SessionPool {
    private static SessionPool INSTANCE = new SessionPool();
    private static Capabilities browserOptions = new ChromeOptions();
    private static WebDriver driver = new RemoteWebDriver(browserOptions);
    private SessionPool() {
    }
    public static SessionPool getINSTANCE() {
        return INSTANCE;
    }
    public WebDriver getDriver(){
        return driver;
    }
}
