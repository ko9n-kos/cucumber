package onliner.pageObject.pages;

import framework.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TvPage extends CatalogBasePage {
    protected static final Label lblViewAll = new Label(By.xpath("//span[contains(text(),'Производитель')]/parent::div//following-sibling::div//div/div[contains(text(),'Все')]"));
    protected static String manufacturer = "//div[@class='schema-filter-popover__wrapper']//child::div//child::span[text()= '%s']";
    protected static final TextBox txtboxPrice = new TextBox(By.xpath("//div[@class='schema-filter__group']//child::input[@type='text' and contains(@placeholder, 'до')]"));
    protected static final DropDown drpDownDiagonalFrom = new DropDown(By.xpath("//div[@class='schema-filter__group']/child::div[1]/child::select"));
    protected static final DropDown drpDownDiagonalTo = new DropDown(By.xpath("//div[@class='schema-filter__group']/child::div[2]/child::select"));
    protected static String resolution = "//span[contains(text(),'Разрешение')]//parent::div/following-sibling::div//child::span[contains(text(),'%s')]";
    protected static final Label lblProductPrice = new Label(By.xpath("//div[@class='schema-product__price']//child::span[contains(@data-bind, 'Price')]"));
    protected static final Label lblProductBrand = new Label(By.xpath("//div[@class='schema-product__title']//child::span[contains(@data-bind, 'name')]"));
    protected static final Label lblProductDescription = new Label(By.xpath("//div[@class='schema-product__description']//child::span[contains(@data-bind, 'description')]"));
    protected static final Button btnModalCity = new Button(By.xpath("//div[contains(@class, 'popover-style__content')]//child::span[contains(text(), 'Да')]"));
    protected static final Label lblProduct = new Label(By.xpath("//div[@id = 'schema-products']//child::div[@class='schema-product__group']"));
    protected static final Label lblTvPageTitle = new Label(By.xpath("//div[@id='schema-top-button']/following-sibling::h1"));

    public TvPage() {
        super(lblTvPageTitle);
    }

    public void selectManufacturer(String option) {
        closeModal();
        lblViewAll.clickViaJs();
        Checkbox checkboxManufacturer = new Checkbox(By.xpath(String.format(manufacturer, option)));
        checkboxManufacturer.moveAndClick();
        checkboxManufacturer.isSelected();
    }

    public void selectResolution(String option) {
        Checkbox checkboxResolution = new Checkbox(By.xpath(String.format(resolution, option)));
        checkboxResolution.clickViaJs();
        checkboxResolution.isSelected();
    }

    public void setMaxPrice(String value) {
        txtboxPrice.enterValue(value);
    }

    public void setMinDiagonal(String option) {
        drpDownDiagonalFrom.scrollToElement();
        drpDownDiagonalFrom.selectFromDrpDown(option);
    }

    public void setMaxDiagonal(String option) {
        drpDownDiagonalTo.selectFromDrpDown(option);
    }

    public void checkProductsPrice(String expected) {
        lblProduct.isStaled();
        lblProduct.scrollToElement();
        List<WebElement> listOfResults = lblProductPrice.findElements();
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(Double.parseDouble(listOfResults.get(listOfResults.indexOf(el)).getText()
                    .replace(" р.", "").replace(',', '.')) <= Double.parseDouble(expected));
        }
    }

    public void checkProductsBrand(String expected) {
        List<WebElement> listOfResults = lblProductBrand.findElements();
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(listOfResults.get(listOfResults.indexOf(el)).getText().contains(expected));
        }
    }

    public void checkProductsDiagonal(String expectedMin, String expectedMax) {
        lblProductDescription.scrollToElement();
        List<WebElement> listOfResults = lblProductDescription.findElements();
        for (WebElement el : listOfResults) {
            String st = listOfResults.get(listOfResults.indexOf(el)).getText().replace(",", "").trim();
            softAssert.assertTrue(Double.parseDouble(st.substring(0, 1)) >= Double.parseDouble(expectedMin.replace("\"", "")) &&
                    Double.parseDouble(st.substring(0, 1)) <= Double.parseDouble(expectedMax.replace("\"", "")));
        }
    }

    public void checkProductsResolution(String expected) {
        List<WebElement> listOfResults = lblProductDescription.findElements();
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(listOfResults.get(listOfResults.indexOf(el)).getText().contains(expected));
        }
    }

    public void closeModal() {
        btnModalCity.click();
    }
}