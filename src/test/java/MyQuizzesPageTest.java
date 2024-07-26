import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.MyQuizzesPage;
import PageModels.QuizFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyQuizzesPageTest extends BaseTest {

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
        quizFormPage = new QuizFormPage(driver);
        homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void userCanCreateQuizzes() {
        myQuizzesPage.clickOnAddQuizBtn();
        quizFormPage.clickOnAddQuestionBtn();
        quizFormPage.fillAndSaveTheQuestionModal("test", "test", "test");
        Alert alert = quizFormPage.getAlert();
        String alertText = alert.getText();
        assertEquals("Save new task?", alertText);
        alert.accept();
    }

    @Test
    public void userCanDeleteQuizzes() {
        myQuizzesPage.deleteQuiz();
        Alert alert = quizFormPage.getAlert();
        String alertText = alert.getText();
        assertEquals("Delete?", alertText);
        alert.accept();
    }

    @Test
    public void userCanModifyTitleOfExistingQuizzes() {
        quizFormPage.modifyQuizTitle("new-test");
        Alert alert = quizFormPage.getAlert();
        String alertText = alert.getText();
        assertEquals("Save changes?", alertText);
        alert.accept();
    }

    @Test
    public void userCanModifyTitleOfExistingQuestions() {
        quizFormPage.modifyQuestion("newQuestionTitle");
        Alert alert = quizFormPage.getAlert();
        String alertText = alert.getText();
        assertEquals("Save changes?", alertText);
        alert.accept();
    }

    @Test
    public void userCanCreateGameLobby() {
        myQuizzesPage.createLobby();
        assertEquals("Start", myQuizzesPage.startBtnText());
    }
}