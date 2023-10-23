package framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static io.qameta.allure.Allure.addAttachment;

public class ScreenshotMaker {
    public static InputStream takeScreenshot() throws IOException {
        return FileUtils.openInputStream(((TakesScreenshot) Browser.driver).getScreenshotAs(OutputType.FILE));
    }
}
