package onliner.pageObject.pages;

import framework.elements.Label;
import org.openqa.selenium.By;

public class CatalogPage extends CatalogBasePage {
    public static final Label lblCatalogPageTitle = new Label (By.xpath("//div[@class='catalog-navigation__title' and contains(text(), 'Каталог')]"));

    public CatalogPage() {
        super(lblCatalogPageTitle);
    }
}