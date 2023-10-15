package onliner.pageObject.commonLogic;

import framework.elements.Label;
import org.openqa.selenium.By;

public class Header {
    protected String mainMenu = "//span[contains(@class,'main-navigation') and text()='%s']";

    public void selectMainNavigationOption(String option) {
        Label lblMainMenu = new Label(By.xpath(String.format(mainMenu, option)));
        lblMainMenu.click();
    }
}
