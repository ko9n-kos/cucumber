package framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.*;


public class BaseTest {
    protected static Browser browser = new Browser();

    @BeforeTest
    public static void setUp() throws IOException {
        if(Browser.driver!=null)
        {
            browser.quitDriver();
        }
        browser.getInstance();
        browser.setUpWait();
        browser.maximizeWindow();
        browser.getUrl();
    }

    @AfterTest
    public static void tearDown() {
        browser.quitDriver();
    }
}