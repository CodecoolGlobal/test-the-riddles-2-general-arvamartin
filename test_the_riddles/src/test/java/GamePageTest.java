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

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GamePageTest  {

    private WebDriver driver;
    private WebDriver driver2;
    private WebDriverWait wait1;
    private WebDriverWait wait2;
    private LoginPage loginPage1;
    private LoginPage loginPage2;
    private HomePage homePage1;
    private HomePage homePage2;
    private MyQuizzesPage myQuizzesPage;
    private GamesPage gamesPage;


    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        driver2 = new EdgeDriver();
        loginPage1 = new LoginPage(driver);
        homePage1 = new HomePage(driver);
        homePage2 = new HomePage(driver2);
        homePage1.openTheApp();
        loginPage2 = new LoginPage(driver2);
        homePage2.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        gamesPage = new GamesPage(driver2);
        driver.manage().window().maximize();
        driver2.manage().window().maximize();
        wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2 = new WebDriverWait(driver2, Duration.ofSeconds(3));

        homePage1.navigateToLoginPage();
        homePage2.navigateToLoginPage();
        loginPage1.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        loginPage2.login(System.getenv("USER_NAME2"), System.getenv("PASSWORD2"));

    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @Test
    void testPlayingGame() throws InterruptedException {

        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.createLobby();
        gamesPage.navigateToGamesPage();
        gamesPage.joinGameLobby("test1");
        gamesPage.joinGame();
        myQuizzesPage.startGame();
        gamesPage.chooseFirstAnswer();
        myQuizzesPage.checkTheResults();

        WebElement scoreBoard = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div")));
        assertEquals("SCOREBOARD", scoreBoard.getText());

    }
}
