package ZaycevMaven.ZaycevMavenProject.ZaycevBlocks;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

@Name("Zaycev Searching songs block")
@FindBy(xpath = "//div[@class='search-page__precise search-precise clearfix']")
public class SearchBlock extends HtmlElement{

    Actions actions;

    @Name("Search songs input")
    @FindBy(xpath ="//*[@id='search-form-query']")
    protected TextInput searchInput;

    @Name("Find Button")
    @FindBy(xpath =".//*[@id='search-form']//button")
    protected Button findButton;

    @Name("First song group")
    @FindBy(xpath ="//div[@class='musicset-track clearfix'][1]//div[@class='musicset-track__artist']/a")
    protected Link firstSongGroup;

    @Name("Play first song button")
    @FindBy(xpath =".//*[@class='musicset-track clearfix'][1]//i[@class='musicset-player__icon']")
    protected Button playFirstSong;

    @Name("Dowload first song button")
    @FindBy(xpath =".//*[@class='musicset-track clearfix'][1]//i[@class='musicset-icon musicset-icon_download']")
    protected Button downloadFirstSong;

    @Name("Playing first song bar")
    @FindBy(xpath =".//div[@class='musicset-progress__gap']")
    protected HtmlElement playingFirstSongProgressBar;

    public void allocateSerchInput() throws HtmlElementsException{
        searchInput.click();
    }

    public void  insertInSearchInput(String inputValue) throws HtmlElementsException {
        searchInput.sendKeys(inputValue);
    }

    public void clickFindButton() throws HtmlElementsException {
        findButton.click();
    }

    public String  getFirstSongGroup() throws HtmlElementsException {
        return firstSongGroup.getText();
    }

    public void clickPlayFirsSongButton() throws HtmlElementsException {
        playFirstSong.click();
    }

    public void moveToFirstSongButton() throws HtmlElementsException {
        actions.moveToElement(playFirstSong);
    }

    public void clickDownloadFirstSongButton() throws HtmlElementsException {
        downloadFirstSong.click();
    }

    public boolean checkPlayingFirstSongBar() throws HtmlElementsException {
        return playingFirstSongProgressBar.isDisplayed();
    }
}
