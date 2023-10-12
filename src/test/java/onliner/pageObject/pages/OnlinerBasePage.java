package onliner.pageObject.pages;

import framework.BasePage;
import framework.elements.BaseElement;
import lombok.Getter;
import onliner.pageObject.commonLogic.MainMenu;

@Getter
public class OnlinerBasePage extends BasePage {

    MainMenu mainMenu = new MainMenu();

    public OnlinerBasePage(BaseElement title) {
        super(title);
    }
}