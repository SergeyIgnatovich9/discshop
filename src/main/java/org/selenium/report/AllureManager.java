package org.selenium.report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.selenium.driver.DriverManager;
import java.util.HashMap;
import java.util.Map;
import static org.selenium.config.ConfigurationManager.configuration;

public class AllureManager {

    private AllureManager() {
    }

    public static void setAllureEnvironmentInformation() {
        var basicInfo = new HashMap<>(Map.of(
                "Test URL", configuration().url(),
                "Target execution", configuration().target(),
                "Headless mode", String.valueOf(configuration().headless()),
                "Local browser", configuration().browser()));
        if (configuration().target().equals("remote")) {
            var gridMap = Map.of("Grid URL", configuration().gridUrl(), "Grid port", configuration().gridPort());
            basicInfo.putAll(gridMap);
        }
        AllureEnvironmentWriter.allureEnvironmentWriter(ImmutableMap.copyOf(basicInfo));
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Browser information", type = "text/plain")
    public static String addBrowserInformation() {
        return DriverManager.getInfo();
    }
}