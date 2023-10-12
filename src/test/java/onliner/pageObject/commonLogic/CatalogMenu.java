package onliner.pageObject.commonLogic;

import framework.elements.BaseElement;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CatalogMenu {

    private static final String catalogNavigationList = "//li[@data-id='12']/following-sibling::li//child::span[contains(text(), '%s')]";
    private static final String electronicAsideList = "//div[@data-id='1']//child::div[contains(text(), '%s')]";
    private static final String tvAndVideoAsideList = "//div[@data-id='1']//child::div//child::span[contains(text(), '%s')]";

    public BaseElement lblCatalogMainMenu(String option){
        return new Label(By.xpath(String.format(catalogNavigationList, option)));
    }

    public void selectCatalogListOption(String option) {
        lblCatalogMainMenu(option).click();
    }

    public BaseElement lblElectronicAsideList(String option){
        return new Label(By.xpath(String.format(electronicAsideList, nbspReplacement(option))));
    }

    public void selectElectronicOption(String option) {
        lblElectronicAsideList(option).click();
    }

    public BaseElement lblTvAndVideoAsideList(String option){
        return new Label(By.xpath(String.format(tvAndVideoAsideList, option)));
    }

    public void selectTvAndVideoOption(String option) {
        lblTvAndVideoAsideList(option).click();
    }

    public String nbspReplacement(String option) {
        if (option.contains("и ")) {
            return option.replace("и ", "и ");
        }
        return option;
    }
}
