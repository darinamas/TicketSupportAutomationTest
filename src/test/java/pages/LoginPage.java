package pages;

//import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {
    @FindBy(id = "username")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class = 'alert alert-danger']")
    private WebElement errorText;

    public LoginPage() {
        PageFactory.initElements(BaseSeleniumPage.driver, this);
    }

    public TicketsPage auth(String loginValue, String passwordValue) {
        loginField.sendKeys(loginValue);
        passwordField.sendKeys(passwordValue, Keys.ENTER);

        return new TicketsPage();
    }

    public LoginPage invalidAuth(String loginValue, String passwordValue) {
        loginField.sendKeys(loginValue);
        passwordField.sendKeys(passwordValue, Keys.ENTER);
        return this;
    }

    public String getErrorText() {
        return  errorText.getText();
    }

    public Boolean isErrorDisplayed() {
        return errorText.isDisplayed();
    }

}
