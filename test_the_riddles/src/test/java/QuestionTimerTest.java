import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTimerTest extends BaseTest{
   private MyQuizzesPage myQuizzesPage;
   private LoginPage loginPage;
   private HomePage homePage;
    private String userName= System.getenv("USER_NAME");
    private String password= System.getenv("PASSWORD");


    @BeforeEach
    public void setUp() throws InterruptedException {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage= new HomePage(driver);
        homePage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        homePage.navigateToLoginPage();
        loginPage.login(userName,password);
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

   @Test
    void userCanSetTime() throws InterruptedException {
        String expected = "15";
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.setTimer(expected);
        String actual = driver.findElement(By.xpath("//*[@id=\"-1time\"]")).getAttribute("value");
        assertEquals(expected, actual);
    }


    @Test
    void userCannotSetNegativeTime() throws InterruptedException {
        String time = "-15";
        String expected = "0";
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.setTimer(time);
        String actual = driver.findElement(By.xpath("//*[@id=\"-1time\"]")).getAttribute("value");
        assertEquals(expected, actual);
    }

    @Test
    void onlyNumbersCanBeAcceptedAsTime() throws InterruptedException {
        String letter = "m";
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.setTimer(letter);

        String actual = driver.findElement(By.xpath("//*[@id=\"-1time\"]")).getAttribute("value");
        assertNotEquals(letter, actual);
    }
}
