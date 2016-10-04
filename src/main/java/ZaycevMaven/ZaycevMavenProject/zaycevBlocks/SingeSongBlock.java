package ZaycevMaven.ZaycevMavenProject.zaycevBlocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

@Name("Single song info block")
@FindBy(xpath = "//div[@id='audiotrack-info']]")
public class SingeSongBlock extends HtmlElement{

    @Name("Song group name")
    @FindBy(xpath =".//div[@id='audiotrack-page']//a[@class='musicset-track__link link-without-title']")
    protected Link songGroupName;

    @Name("Download Song Button")
    @FindBy(xpath ="//i[@class='audiotrack-icon audiotrack-icon_download']")
    protected Button downloadSongButton;

    @Name("Search link")
    @FindBy(xpath =".//*[@id='zina-region-leftmenutop']//li[1]/a")
    protected Link searchLinkAAA;


    public String getSongGroupName() throws HtmlElementsException {
        return songGroupName.getText();
    }

    public boolean downloadSongButtonIsEnabled() throws HtmlElementsException {
        return downloadSongButton.isDisplayed();
    }

    public void clickSearchAAA() throws HtmlElementsException {
        searchLinkAAA.click();
    }
}
