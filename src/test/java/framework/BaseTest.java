package framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.*;

public class BaseTest extends Browser {

    public static Browser browser = new Browser();

    @BeforeTest
    public static void setUp() throws IOException {
        browser.getInstance();
        browser.setUpWait();
        browser.maximizeWindow();
        browser.timeout();
        browser.getUrl();
    }

    @AfterTest
    public static void finish() {
        browser.quitDriver();
    }
}