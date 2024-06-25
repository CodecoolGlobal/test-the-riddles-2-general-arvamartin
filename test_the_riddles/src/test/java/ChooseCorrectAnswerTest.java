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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChooseCorrectAnswerTest {

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

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @Test
    void userCanChooseCorrectAnswer() throws InterruptedException {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn.click();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.chooseCheckBoxOne();
        Boolean actual =  driver.findElement(By.xpath("//*[@id=\"checkbox-1\"]")).isSelected();
        assertTrue(actual);
    }

    @Test
    void userCanChooseMultipleCorrectAnswer() throws InterruptedException {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn.click();
        loginPage.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.clickOnAddQuizBtn();
        myQuizzesPage.clickOnAddQuestionBtn();
        myQuizzesPage.chooseCheckBoxOne();
        myQuizzesPage.chooseCheckBoxTwo();
        Boolean actual1 =  driver.findElement(By.xpath("//*[@id=\"checkbox-1\"]")).isSelected();
        Boolean actual2 =  driver.findElement(By.xpath("//*[@id=\"checkbox-2\"]")).isSelected();
        assertTrue(actual1 && actual2);
    }
}
