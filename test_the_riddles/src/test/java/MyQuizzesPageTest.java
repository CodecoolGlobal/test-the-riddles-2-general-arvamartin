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

import static org.junit.Assert.assertEquals;


class MyQuizzesPageTest {

    WebDriver driver;
    MyQuizzesPage myQuizzesPage;
    LoginPage loginPage;
    WebDriverWait wait;


    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("http://localhost:3000");
        loginPage = new LoginPage(driver);
        myQuizzesPage = new MyQuizzesPage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }


    @Test
    /*public void userCanCreateQuizzes() throws InterruptedException {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));

        loginBtn.click();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.fillAndSaveTheQuestionModal("test", "test", "test");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assertEquals("Save new task?", alertText);
        alert.accept();
    }


    @Test
    public void userCanDeleteQuizzes() throws InterruptedException {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn.click();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.deleteQuiz();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assertEquals("Delete?", alertText);
        alert.accept();
    }*/

    public void userCanCreateGameLobby() throws InterruptedException {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn.click();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.createLobby();

        assertEquals("Start", myQuizzesPage.startBtnText());
    }

   /* @AfterEach
    public void closeTheApp() {
        driver.quit();
    }*/

}