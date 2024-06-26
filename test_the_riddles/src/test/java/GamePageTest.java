import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GamePageTest {

    WebDriver driver;
    WebDriver driver2;
    WebDriverWait wait;
    LoginPage loginPage1;
    LoginPage loginPage2;
    MyQuizzesPage myQuizzesPage1;
    MyQuizzesPage myQuizzesPage2;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        driver2 = new EdgeDriver();
        driver.get("http://localhost:3000");
        driver2.get("http://localhost:3000");
        loginPage1 = new LoginPage(driver);
        loginPage2 = new LoginPage(driver2);
        myQuizzesPage1 = new MyQuizzesPage(driver);
        myQuizzesPage2 = new MyQuizzesPage(driver2);
        driver.manage().window().maximize();
        driver2.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait = new WebDriverWait(driver2, Duration.ofSeconds(3));

        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn.click();
        loginPage1.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        loginPage1.login(System.getenv("USER_NAME2"), System.getenv("PASSWORD2"));

    }

    @Test
    void testGamePage() throws InterruptedException {
            myQuizzesPage1.clickOnMyQuizzesBtn();
            myQuizzesPage1.clickOnMyQuizzesBtn();
            myQuizzesPage2.joinGame();
    }

}
