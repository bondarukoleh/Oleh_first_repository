package ZaycevMaven.ZaycevMavenProject.ZaycevBlocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Zaycev Function block")
@FindBy(xpath = "//div[@class='region_name_leftmenutop']")
public class FunctionBlock extends HtmlElement{

    @Name("Search link")
    @FindBy(xpath =".//*[@id='zina-region-leftmenutop']//li[1]/a")
    protected Link searchLink;

    public void  clickSearchLink(){
        searchLink.click();
    }
}
