package ZaycevMaven.ZaycevMavenProject.ZaycevBlocks;

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
    @FindBy(xpath ="//a[@id='audiotrack-download-link']")
    protected Button downloadSongButton;

    public String getSongGroupName() throws HtmlElementsException {
        return songGroupName.getText();
    }

    public boolean downloadSongButtonIsEnabled() throws HtmlElementsException {
        return downloadSongButton.isEnabled();
    }
}
