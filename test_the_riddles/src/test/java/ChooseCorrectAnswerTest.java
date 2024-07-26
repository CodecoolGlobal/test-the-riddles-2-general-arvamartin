import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.MyQuizzesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
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
    public void setUp() {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    void userCanChooseCorrectAnswer() {
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.chooseCheckBoxOne();
        boolean actual = myQuizzesPage.getCheckBoxOne().isSelected();
        assertTrue(actual);
    }

    @Test
    void userCanChooseMultipleCorrectAnswer() {
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.chooseCheckBoxOne();
        myQuizzesPage.chooseCheckBoxTwo();
        boolean actual1 = myQuizzesPage.getCheckBoxOne().isSelected();
        boolean actual2 = myQuizzesPage.getCheckBoxTwo().isSelected();
        assertTrue(actual1 && actual2);
    }

    @Test
    void userCannotCreateQuizWithoutChoosingAnAnswer() {
        String expected = myQuizzesPage.getQuestionNumberField().getText();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.clickOnSaveBtn();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        assertEquals(expected, myQuizzesPage.checkQuestionNumber());
    }
}
