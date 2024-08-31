import PageModels.HomePage;
import PageModels.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    void userCanLogout() {
        loginPage.clickOnLogoutBtn();
        homePage.navigateToLoginPage();
        String actualURL = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/login", actualURL);
    }
}
