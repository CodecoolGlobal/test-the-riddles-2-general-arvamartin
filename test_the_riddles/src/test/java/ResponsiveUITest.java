import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.MyQuizzesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResponsiveUITest extends BaseTest {

    private LoginPage loginPage;
    private MyQuizzesPage myQuizzesPage;
    private HomePage homePage;

    @BeforeEach
    void setUp() throws InterruptedException {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        homePage.navigateToLoginPage();
        loginPage.login("test", "test");
        myQuizzesPage.clickOnMyQuizzesBtn();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    void testResponsiveUI() {
        //Desktop
        assertTrue(myQuizzesPage.testResponsiveLayout(new Dimension(1920, 1080)));

        //Tablet
        assertTrue(myQuizzesPage.testResponsiveLayout(new Dimension(768, 1024)));

        //Mobile
        assertTrue(myQuizzesPage.testResponsiveLayout(new Dimension(375, 667)));
    }
}
