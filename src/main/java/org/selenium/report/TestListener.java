package org.selenium.report;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        AllureManager.takeScreenshot();
        AllureManager.addBrowserInformation();
    }
}