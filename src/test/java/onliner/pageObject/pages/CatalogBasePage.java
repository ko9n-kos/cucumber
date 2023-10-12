package onliner.pageObject.pages;

import framework.elements.BaseElement;
import lombok.Getter;
import onliner.pageObject.commonLogic.CatalogMenu;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.PropertyReader.getProperties;

@Getter
public class CatalogBasePage extends OnlinerBasePage{

    CatalogMenu catalogMenu = new CatalogMenu();

    public CatalogBasePage(BaseElement title) {
        super(title);
    }
}