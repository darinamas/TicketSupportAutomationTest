package helpDesk;

import core.BaseSeleniumTest;
import helpers.TestValues;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import readProperties.ConfigProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

import static helpers.StringModifier.getUniqueString;

public class HelpDeskTest extends BaseSeleniumTest {

    @Test
    public void checkTicket() {
        String title = getUniqueString(TestValues.TEST_TITLE); //"Hello dar" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String email = getUniqueString(TestValues.TEST_EMAIL) + "@email.com";

        TicketPage ticketPage = new MainPage()
                .createTicket(title, TestValues.TEST_BODY, email)
                .openLoginPage()
                .auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASSWORD)
                .findTicket(title);

        Assert.assertTrue(ticketPage.getTitle().contains(title));
        Assert.assertEquals(ticketPage.getBody(), TestValues.TEST_BODY);
        Assert.assertEquals(ticketPage.getEmail(), email);
    }
}
