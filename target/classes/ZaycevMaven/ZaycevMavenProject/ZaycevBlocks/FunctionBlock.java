package ZaycevMaven.ZaycevMavenProject.zaycevBlocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

@Name("Zaycev Function block")
@FindBy(xpath = "//div[@class='region_name_leftmenutop']")
public class FunctionBlock extends HtmlElement{

    @Name("Search link")
    @FindBy(xpath =".//*[@id='zina-region-leftmenutop']//li[1]/a")
    protected Link searchLink;

    public void  clickSearchLink() throws HtmlElementsException {
        searchLink.click();
    }
}
