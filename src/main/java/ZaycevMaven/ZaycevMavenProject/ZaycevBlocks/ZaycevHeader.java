package ZaycevMaven.ZaycevMavenProject.ZaycevBlocks;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

@Name("Zaycev Header")
@FindBy(xpath = "//div[@id='page-head']")
public class ZaycevHeader extends HtmlElement{

    @Name("Login button")
    @FindBy(xpath ="//a[@class='user-head-wrap__link user-head-wrap__link_login']")
    protected Button loginButton;

    @Name("User Email input")
    @FindBy(xpath =".//*[@id='j_username_']")
    protected TextInput userEmaiInput;

    @Name("User Password input")
    @FindBy(xpath =".//*[@id='j_password_']")
    protected TextInput userPasswordInput;

    @Name("Enter Button")
    @FindBy(xpath ="//div[@class='authentication__submit registration__button clearfix']/button")
    protected Button enterButton;

    @Name("Displayed User Name")
    @FindBy(xpath =".//*[@class='person-profile-info__open-menu']")
    protected HtmlElement loggedUserName;


    public void clickLoginButton() throws HtmlElementsException{
        loginButton.click();
    }

    public void enterUserEmail(String userName) throws HtmlElementsException {
        userEmaiInput.sendKeys(userName);
    }

    public void enterUserPassword(String userPass) throws HtmlElementsException {
        userPasswordInput.sendKeys(userPass);
    }

    public void clickEnterButton() throws HtmlElementsException {
        enterButton.click();
    }

    public String getLoggedUserName() throws HtmlElementsException {
        return loggedUserName.getText();
    }

}
