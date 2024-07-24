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


class MyQuizzesPageTest {

    private WebDriver driver;
    private MyQuizzesPage myQuizzesPage;
    private LoginPage loginPage;
    private WebDriverWait wait;
    private HomePage homePage;


    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        homePage.navigateToLoginPage();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
    }


    @Test
    public void userCanCreateQuizzes() throws InterruptedException {
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.fillAndSaveTheQuestionModal("test", "test", "test");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assertEquals("Save new task?", alertText);
        alert.accept();
    }


    @Test
    public void userCanDeleteQuizzes() {
        myQuizzesPage.deleteQuiz();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assertEquals("Delete?", alertText);
        alert.accept();
    }

    @Test
    public void userCanModifyTitleOfExistingQuizzes() {
        myQuizzesPage.modifyQuizTitle("new-test");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assertEquals("Save changes?", alertText);
        alert.accept();
    }

    @Test
    public void userCanModifyTitleOfExistingQuestions() throws InterruptedException {
        myQuizzesPage.modifyQuestion("newQuestionTitle");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assertEquals("Save changes?", alertText);
        alert.accept();
    }

    @Test
    public void userCanCreateGameLobby() {
        myQuizzesPage.createLobby();
        assertEquals("Start", myQuizzesPage.startBtnText());
    }

    @AfterEach
    public void closeTheApp() {
        driver.quit();
    }
}