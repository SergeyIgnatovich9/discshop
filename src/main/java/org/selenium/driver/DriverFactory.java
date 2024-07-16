package org.selenium.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.selenium.config.ConfigurationManager;
import java.net.URI;
import static java.lang.String.format;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    public WebDriver createInstance(String browser) {
        String target = ConfigurationManager.configuration().target();

        return switch (target) {
            case "local" -> Browser.valueOf(ConfigurationManager.configuration().browser().toUpperCase()).createLocalDriver();
            case "remote" -> createRemoteInstance(Browser.valueOf(browser.toUpperCase()).getOptions());
            default -> Browser.valueOf(ConfigurationManager.configuration().browser().toUpperCase()).createLocalDriver();
        };
    }

    private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = format("http://%s:%s",
                    ConfigurationManager.configuration().gridUrl(),
                    ConfigurationManager.configuration().gridPort());

            remoteWebDriver = new RemoteWebDriver(URI.create(gridURL).toURL(),capability);
        } catch (java.net.MalformedURLException e) {
            logger.error ("Grid URL is invalid or Grid is not available");
            logger.error (format("Browser: %s", capability.getBrowserName()), e);
        } catch (IllegalArgumentException e) {
            logger.error(format("Browser %s is not valid or recognized", capability.getBrowserName()), e);
        }
        return remoteWebDriver;
    }
}
