package org.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static final String BROWSER = System.getProperty("browser", String.valueOf(Browser.CHROME));
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(new DriverFactory().createInstance(BROWSER));
        }
        return driver.get();
    }

    public static void tearDown() {
        DriverManager.driver.get().quit();
        driver.remove();
    }

    public static String getInfo() {
        var cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName();
        String platform = cap.getPlatformName().toString();
        String version = cap.getBrowserVersion();
        return String.format("browser: %s version: %s platform: %s", browserName, version, platform);
    }
}

