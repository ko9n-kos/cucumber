package onliner.pageObject.commonLogic;

import framework.elements.BaseElement;
import framework.elements.Label;
import org.openqa.selenium.By;

public class MainMenu {

    protected String mainMenu = "//span[contains(@class,'main-navigation') and text()='%s']";

    public BaseElement mainNavigationOption(String option){
        return new Label(By.xpath(String.format(mainMenu, option)));
    }

    public void selectMainNavigationOption(String option) {
        mainNavigationOption(option).click();
    }
}
