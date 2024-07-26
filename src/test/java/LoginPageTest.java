import PageModels.HomePage;
import PageModels.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    private final String UNREGISTERED_USERNAME = "t e s t";
    private final String UNREGISTERED_PASSWORD = "t e s t";

    @BeforeEach
    public void setUp() {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        homePage.navigateToLoginPage();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void testLoginProcessWithRegisteredCredentials() {
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        assertEquals("Logout", loginPage.findLogoutBtn().getText());
    }

    @Test
    public void testLoginProcessWithUnRegisteredCredentials() {
        loginPage.login(UNREGISTERED_USERNAME, UNREGISTERED_PASSWORD);
        assertNotEquals("Logout", loginPage.findLogoutBtn().getText());
    }
}
