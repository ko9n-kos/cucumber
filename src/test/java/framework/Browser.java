package framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static framework.DriverFactory.browserSetUp;
import static framework.PropertyReader.getProperties;
import static io.qameta.allure.Allure.addAttachment;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void getInstance() throws IOException {
        driver = browserSetUp();
        timeout();
    }

    public void setUpWait() throws IOException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getProperties("config.properties", "timeOut"))));
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void timeout() throws IOException {
        driver.manage().timeouts().implicitlyWait(Integer
                .parseInt(getProperties("config.properties", "timeOut")), TimeUnit.SECONDS);
    }

    public void getUrl() throws IOException {
        driver.get(getProperties("config.properties", "siteUrl"));
    }

    public void quitDriver() {
        driver.quit();
    }

    public static void waitForPageLoad() {
        try {
            wait.until((ExpectedCondition<Boolean>) d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                return result instanceof Boolean && (Boolean) result;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}