package helpDesk;

import core.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import readProperties.ConfigProvider;

public class LoginPageTest extends BaseSeleniumTest {

    @Test
    public void testLogin() {
        var ticketsPage = new MainPage()
                .openLoginPage()
                .auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASSWORD);

        Assert.assertEquals(ticketsPage.getWelcomeText(), "Welcome to the django-helpdesk demo. Email is disabled.");
    }

    @Test
    public void testInvalidLogin() {
        var loginPage = new MainPage()
                .openLoginPage()
                .invalidAuth(ConfigProvider.INVALID_LOGIN, ConfigProvider.INVALID_PASSWORD);

        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertEquals(loginPage.getErrorText(), "Your username and password didn't match. Please try again.");
    }

}
