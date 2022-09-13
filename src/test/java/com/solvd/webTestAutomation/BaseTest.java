package com.solvd.webTestAutomation;

import com.google.common.io.Files;
import com.solvd.webTestAutomation.service.SessionPool;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    @BeforeMethod
    public void setUp() {
        driver.get("https://pearnft.herokuapp.com/");
    }
    @AfterMethod
    public void recordFailure (ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File ("src/test/resources/testFailuresScreenshots/" + testResult.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @AfterSuite
    public void closeSession(){
        driver.close();
    }
}
