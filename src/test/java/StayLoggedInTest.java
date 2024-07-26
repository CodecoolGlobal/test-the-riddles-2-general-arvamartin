import PageModels.HomePage;
import PageModels.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.*;

class StayLoggedInTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private final int SLEEP_TIME = 2000;

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
    void testRefreshThePageAndStayedLoggedIn() throws InterruptedException {
        Thread.sleep(SLEEP_TIME);
        driver.navigate().refresh();
        Thread.sleep(SLEEP_TIME);
        String actual = loginPage.getLogoutBtnText();
        assertEquals("Logout", actual);
    }

    @Test
    void testOpenNewTabAndStayedLoggedIn() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open('http://localhost:3000/','_blank');");
        Thread.sleep(SLEEP_TIME);
        String actual = loginPage.getLogoutBtnText();
        assertEquals("Logout", actual);
    }
}