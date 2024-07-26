import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.MyQuizzesPage;
import PageModels.QuizFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTimerTest extends BaseTest {
    private MyQuizzesPage myQuizzesPage;
    private QuizFormPage quizFormPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private String userName = System.getenv("USER_NAME");
    private String password = System.getenv("PASSWORD");

    @BeforeEach
    public void setUp() throws InterruptedException {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        quizFormPage = new QuizFormPage(driver);
        homePage.navigateToLoginPage();
        loginPage.login(userName, password);
        homePage.navigateToMyQuizPage();
        myQuizzesPage.clickOnAddQuizBtn();
        quizFormPage.clickOnAddQuestionBtn();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    void userCanSetTime() {
        String expected = "15";
        quizFormPage.setTimer(expected);
        String actual = quizFormPage.getTimer().getAttribute("value");
        assertEquals(expected, actual);
    }

    @Test
    void userCannotSetNegativeTime() {
        String time = "-15";
        String expected = "0";
        quizFormPage.setTimer(time);
        String actual = quizFormPage.getTimer().getAttribute("value");
        assertEquals(expected, actual);
    }

    @Test
    void onlyNumbersCanBeAcceptedAsTime() {
        String letter = "m";
        quizFormPage.setTimer(letter);
        String actual = quizFormPage.getTimer().getAttribute("value");
        assertNotEquals(letter, actual);
    }
}
