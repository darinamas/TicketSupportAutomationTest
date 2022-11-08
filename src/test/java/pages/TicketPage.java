package pages;

//import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketPage extends BaseSeleniumPage {
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/div/div/table/tbody/tr[2]/td[2]")
    private WebElement email;

    @FindBy(xpath = "//h3")
    private WebElement title;

    @FindBy(css = "td[id='ticket-description'] p")
    private WebElement body;

    public TicketPage() { //constructor
        PageFactory.initElements(BaseSeleniumPage.driver, this); //init all elements on this page
    }

    public  String getEmail(){
        System.out.println(email.getText());
        return email.getText();
    }
    public  String getTitle(){
        System.out.println(title.getText());
        return title.getText();
    }

    public  String getBody(){
        System.out.println(body.getText());
        return body.getText();
    }
}
