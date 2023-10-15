package onliner.pageObject.pages;

import framework.BasePage;
import framework.elements.BaseElement;
import lombok.Getter;
import onliner.pageObject.commonLogic.Header;

@Getter
public class OnlinerBasePage extends BasePage {
    Header header = new Header();

    public OnlinerBasePage(BaseElement title) {
        super(title);
    }
}