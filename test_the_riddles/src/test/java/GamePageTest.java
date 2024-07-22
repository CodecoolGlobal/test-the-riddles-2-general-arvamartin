import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class GamePageTest {

   private WebDriver driver;
   private WebDriver driver2;
   private WebDriverWait wait1;
   private WebDriverWait wait2;
   private LoginPage loginPage1;
   private LoginPage loginPage2;
   private MyQuizzesPage myQuizzesPage1;
   private MyQuizzesPage myQuizzesPage2;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        driver2 = new EdgeDriver();
        loginPage1 = new LoginPage(driver);
        loginPage1.openTheApp();
        loginPage2 = new LoginPage(driver2);
        loginPage2.openTheApp();
        myQuizzesPage1 = new MyQuizzesPage(driver);
        myQuizzesPage2 = new MyQuizzesPage(driver2);
        driver.manage().window().maximize();
        driver2.manage().window().maximize();
        wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2 = new WebDriverWait(driver2, Duration.ofSeconds(3));

        WebElement loginBtn1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        WebElement loginBtn2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn1.click();
        loginBtn2.click();
        loginPage1.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        loginPage2.login(System.getenv("USER_NAME2"), System.getenv("PASSWORD2"));

    }

    @Test
    void testPlayingGame() throws InterruptedException {

        myQuizzesPage1.clickOnMyQuizzesBtn();
        myQuizzesPage1.createLobby();
        myQuizzesPage2.joinGameLobby("finaldemo");
        myQuizzesPage2.joinGame();
        myQuizzesPage1.startGame();
        myQuizzesPage2.chooseGoodAnswer();
        myQuizzesPage1.checkTheResults();

        WebElement scoreBoard = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div")));

        assertEquals("SCOREBOARD", scoreBoard.getText());

    }

}
