package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketsPage extends BaseSeleniumPage {
    @FindBy(id = "search_query")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class = 'tickettitle']")
    private WebElement ticket;

    @FindBy(xpath = "//div[@class='alert alert-info'] /p[1]")
    private WebElement welcomeText;

    public TicketsPage() { //constructor
        PageFactory.initElements(driver, this); //init all elements on this page
    }

    public TicketPage findTicket(String str){
        searchField.sendKeys(str, Keys.ENTER);
        ticket.click();
        return new TicketPage();
    }

    public String getWelcomeText(){
        return welcomeText.getText();
    }
}
