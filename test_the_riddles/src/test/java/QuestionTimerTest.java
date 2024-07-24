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

public class QuestionTimerTest {
   private WebDriver driver;
   private MyQuizzesPage myQuizzesPage;
   private LoginPage loginPage;
   private WebDriverWait wait;
   private HomePage homePage;
    private String userName= System.getenv("USER_NAME");
    private String password= System.getenv("PASSWORD");


    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        loginPage.openTheApp();
        homePage= new HomePage(driver);
        myQuizzesPage = new MyQuizzesPage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        homePage.navigateToLoginPage();
        loginPage.login(userName,password);
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
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
