import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.MyQuizzesPage;
import PageModels.QuizFormPage;
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
    private QuizFormPage quizFormPage;
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
        homePage.navigateToMyQuizPage();
        myQuizzesPage.clickOnAddQuizBtn();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    void userCanChooseCorrectAnswer() {
        quizFormPage.clickOnAddQuestionBtn();
        quizFormPage.chooseCheckBoxOne();
        boolean actual = quizFormPage.getCheckBoxOne().isSelected();
        assertTrue(actual);
    }

    @Test
    void userCanChooseMultipleCorrectAnswer() {
        quizFormPage.clickOnAddQuestionBtn();
        quizFormPage.chooseCheckBoxOne();
        quizFormPage.chooseCheckBoxTwo();
        boolean actual1 = quizFormPage.getCheckBoxOne().isSelected();
        boolean actual2 = quizFormPage.getCheckBoxTwo().isSelected();
        assertTrue(actual1 && actual2);
    }

    @Test
    void userCannotCreateQuizWithoutChoosingAnAnswer() {
        String expected = quizFormPage.getQuestionNumberField().getText();
        quizFormPage.clickOnAddQuestionBtn();
        quizFormPage.clickOnSaveBtn();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        assertEquals(expected, quizFormPage.checkQuestionNumber());
    }
}
