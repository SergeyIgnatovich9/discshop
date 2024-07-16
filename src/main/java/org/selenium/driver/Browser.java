package org.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import static org.selenium.config.ConfigurationManager.configuration;

public enum Browser {

    CHROME {
        @Override
        public WebDriver createLocalDriver() {
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--start-notifications");
            chromeOptions.addArguments("--remote-allow-origins=*");
            if (configuration().headless()) chromeOptions.addArguments("--headless=new");
            return chromeOptions;
        }
    },

    FIREFOX {
        @Override
        public WebDriver createLocalDriver() {
            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            var firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            if (configuration().headless()) firefoxOptions.addArguments("--headless");
            return firefoxOptions;
        }
    },

    EDGE {
        @Override
        public WebDriver createLocalDriver() {
            return new EdgeDriver(getOptions());
        }

        @Override
        public EdgeOptions getOptions() {
            var edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");
            if (configuration().headless()) {
                edgeOptions.addArguments("--headless");
            }
            return edgeOptions;
        }
    },

    SAFARI {
        @Override
        public WebDriver createLocalDriver() {
            return new SafariDriver(getOptions());
        }

        @Override
        public SafariOptions getOptions() {
            var safariOptions = new SafariOptions();
            safariOptions.setAutomaticInspection(false);
            return safariOptions;
        }
    };

    public abstract WebDriver createLocalDriver();

    public abstract AbstractDriverOptions getOptions();
}
