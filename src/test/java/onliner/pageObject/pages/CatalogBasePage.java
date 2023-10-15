package onliner.pageObject.pages;

import framework.elements.BaseElement;
import lombok.Getter;
import onliner.pageObject.commonLogic.CatalogMenu;

@Getter
public class CatalogBasePage extends OnlinerBasePage{
    CatalogMenu catalogMenu = new CatalogMenu();

    public CatalogBasePage(BaseElement title) {
        super(title);
    }
}