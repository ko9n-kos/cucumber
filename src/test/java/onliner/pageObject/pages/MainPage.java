package onliner.pageObject.pages;

import framework.elements.Label;
import org.openqa.selenium.By;

public class MainPage extends OnlinerBasePage {
    public static final Label lblMainPageTitle = new Label (By.xpath("//div[contains(@class, 'b-top-logo')]"));

    public MainPage() {
        super(lblMainPageTitle);
    }
}