package com.solvd.webTestAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotFailureTest extends BaseTest{
    @Test
    public void testScreenshotFailure(){
        Assert.assertEquals(1, 2);
    }
}
