import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.MyQuizzesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTimerTest extends BaseTest {
    private MyQuizzesPage myQuizzesPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private String userName = System.getenv("USER_NAME");
    private String password = System.getenv("PASSWORD");

    @BeforeEach
    public void setUp() {
        initializeWebDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        homePage.navigateToLoginPage();
        loginPage.login(userName, password);
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    void userCanSetTime() {
        String expected = "15";
        myQuizzesPage.setTimer(expected);
        String actual = myQuizzesPage.getTimer().getAttribute("value");
        assertEquals(expected, actual);
    }

    @Test
    void userCannotSetNegativeTime() {
        String time = "-15";
        String expected = "0";
        myQuizzesPage.setTimer(time);
        String actual = myQuizzesPage.getTimer().getAttribute("value");
        assertEquals(expected, actual);
    }

    @Test
    void onlyNumbersCanBeAcceptedAsTime() {
        String letter = "m";
        myQuizzesPage.setTimer(letter);
        String actual = myQuizzesPage.getTimer().getAttribute("value");
        assertNotEquals(letter, actual);
    }
}
