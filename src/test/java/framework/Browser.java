package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static framework.PropertyReader.getProperties;

public class Browser extends DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void getInstance() throws IOException {
        driver = browserSetUp();
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