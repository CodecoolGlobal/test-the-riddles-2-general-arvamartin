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

    private static final String timerFieldXpath = "//*[@id=\"-1time\"]";


    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("http://localhost:3000");
        loginPage = new LoginPage(driver);
        myQuizzesPage = new MyQuizzesPage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

   @Test
    void userCanSetTime() throws InterruptedException {
        String expected = "15";
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn.click();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.setTimer(expected);
        String actual = driver.findElement(By.xpath(timerFieldXpath)).getAttribute("value");
        assertEquals(expected, actual);
    }


    @Test
    void userCannotSetNegativeTime() throws InterruptedException {
        String time = "-15";
        String expected = "0";
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn.click();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.setTimer(time);
        String actual = driver.findElement(By.xpath(timerFieldXpath)).getAttribute("value");
        assertEquals(expected, actual);
    }

    @Test
    void onlyNumbersCanBeAcceptedAsTime() throws InterruptedException {
        String letter = "m";
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));

        loginBtn.click();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.setTimer(letter);

        String actual = driver.findElement(By.xpath(timerFieldXpath)).getAttribute("value");
        assertNotEquals(letter, actual);
    }
}
