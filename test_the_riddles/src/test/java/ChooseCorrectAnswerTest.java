import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChooseCorrectAnswerTest {

    private WebDriver driver;
    private MyQuizzesPage myQuizzesPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriverWait wait;
    private String userName= System.getenv("USER_NAME");
    private String password= System.getenv("PASSWORD");


    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        loginPage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        homePage.navigateToLoginPage();
        loginPage.login(userName,password);
        myQuizzesPage.clickOnMyQuizzesBtn();
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @Test
    void userCanChooseCorrectAnswer() throws InterruptedException {
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.chooseCheckBoxOne();
        Boolean actual = driver.findElement(By.xpath("//*[@id=\"checkbox-1\"]")).isSelected();
        assertTrue(actual);
    }

    @Test
    void userCanChooseMultipleCorrectAnswer() throws InterruptedException {
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.chooseCheckBoxOne();
        myQuizzesPage.chooseCheckBoxTwo();
        Boolean actual1 = driver.findElement(By.xpath("//*[@id=\"checkbox-1\"]")).isSelected();
        Boolean actual2 = driver.findElement(By.xpath("//*[@id=\"checkbox-2\"]")).isSelected();
        assertTrue(actual1 && actual2);
    }

    @Test
    void userCantCreateQuizWithoutChoosingAnAnswer() throws InterruptedException {
        myQuizzesPage.clickOnAddQuizBtn();
        String expected = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div")).getText();
        myQuizzesPage.clickOnAddQuestionBtn();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        assertEquals(expected,myQuizzesPage.checkQuestionNumber());
    }
}
