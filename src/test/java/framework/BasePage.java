package framework;

import framework.elements.BaseElement;

import org.testng.asserts.SoftAssert;

import static framework.Browser.waitForPageLoad;

public class BasePage {
    protected SoftAssert softAssert = new SoftAssert();
    public BaseElement baseElement;

    public BasePage(BaseElement title) {
        baseElement = title;
    }

    public void checkPage() {
        baseElement.waitVisibilityOfElement();
        waitForPageLoad();
    }

}