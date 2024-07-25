import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.MyQuizzesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChooseCorrectAnswerTest extends BaseTest {

    private MyQuizzesPage myQuizzesPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }


    @Test
    void userCanChooseCorrectAnswer() throws InterruptedException {
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.chooseCheckBoxOne();
        boolean actual = driver.findElement(By.xpath("//*[@id=\"checkbox-1\"]")).isSelected();
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
    void userCannotCreateQuizWithoutChoosingAnAnswer() throws InterruptedException {
        myQuizzesPage.clickOnAddQuizBtn();
        String expected = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div")).getText();
        myQuizzesPage.clickOnAddQuestionBtn();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        assertEquals(expected,myQuizzesPage.checkQuestionNumber());
    }
}
