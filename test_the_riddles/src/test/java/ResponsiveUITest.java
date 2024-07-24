import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResponsiveUITest {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private MyQuizzesPage myQuizzesPage;
    private HomePage homePage;

    @BeforeEach
    void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        homePage.navigateToLoginPage();
        loginPage.login("test", "test");
        myQuizzesPage.clickOnMyQuizzesBtn();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
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
