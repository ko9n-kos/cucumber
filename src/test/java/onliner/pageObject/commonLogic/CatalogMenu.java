package onliner.pageObject.commonLogic;

import framework.elements.Label;
import org.openqa.selenium.By;

import static framework.elements.BaseElement.nbspReplacement;

public class CatalogMenu {
    private static final String catalogMenuOption = "//li[@data-id='12']/following-sibling::li//child::span[contains(text(), '%s')]";
    private static final String subMenuOption = "//div[@data-id='1']//child::div[contains(text(), '%s')]";
    private static final String asideListOption = "//div[@data-id='1']//child::div//child::span[contains(text(), '%s')]";

    public void selectCatalogMenuOption(String option) {
        Label lblCatalogMainMenu = new Label(By.xpath(String.format(catalogMenuOption, option)));
        lblCatalogMainMenu.click();
    }

    public void selectSubMenuOption(String option) {
        Label lblSubMenuOption = new Label(By.xpath(String.format(subMenuOption, nbspReplacement(option))));
        lblSubMenuOption.click();
    }

    public void selectAsideListOption(String option) {
        Label lblAsideListOption = new Label(By.xpath(String.format(asideListOption, option)));
        lblAsideListOption.moveAndClick();
    }
}
