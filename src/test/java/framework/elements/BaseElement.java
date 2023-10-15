package framework.elements;

import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement {
    WebDriver driver = Browser.driver;
    WebDriverWait wait = Browser.wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    protected By element;

    public BaseElement(By elementLocator) {
        element = elementLocator;
    }

    public WebElement findElement() {
        return waitToBePresented();
    }

    public void isSelected() {
        try {
            findElement().isSelected();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isStaled() {
        try {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(element)));
        } catch (Exception ignored) {
        }
    }

    public void scrollToElement() {
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block:'center'});", findElement());
    }

    public List<WebElement> findElements() {
        waitToBePresented(element);
        return driver.findElements(element);
    }

    public WebElement waitElementToBeClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(findElement()));
    }

    public WebElement waitToBePresented() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitToBePresented(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitVisibilityOfElement() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    public void clickViaJs() {
        js.executeScript("arguments[0].click();", findElement());
    }

    public void moveAndClick(){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement());
        actions.perform();
        findElement().click();
    }

    public void click() {
        waitElementToBeClickable().click();
    }

    public static String nbspReplacement(String option) {
        if (option.contains("и")) {
            String stringReverse = String.valueOf(new StringBuffer(option).reverse()).replaceFirst(" "," ");
            option= String.valueOf(new StringBuffer(stringReverse).reverse());
            return option;
        }
        return option;
    }
}