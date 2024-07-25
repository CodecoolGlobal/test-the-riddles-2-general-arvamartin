import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest extends BaseTest{
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    public void setUp()  {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
    }

    @Test
    void userCanLogout() {
        loginPage.clickOnLogoutBtn();
        String expectedURL = "http://localhost:3000/login";
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        String actualURL = driver.getCurrentUrl();
        assertEquals(expectedURL,actualURL);
    }
}
