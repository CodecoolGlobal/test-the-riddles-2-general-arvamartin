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


public class GamePageTest  extends BaseTest{

    private WebDriver driver2;
    private WebDriverWait wait2;
    private LoginPage loginPage1;
    private LoginPage loginPage2;
    private HomePage homePage1;
    private HomePage homePage2;
    private MyQuizzesPage myQuizzesPage;
    private GamesPage gamesPage;

    private final int WAIT_SECONDS = 3;
    private final String SECOND_USER_USERNAME = "abc";
    private final String SECOND_USER_PASSWORD = "abc";


    @BeforeEach
    public void setUp() throws InterruptedException {
        initializeWebDriver();
        driver2 = new EdgeDriver();
        loginPage1 = new LoginPage(driver);
        homePage1 = new HomePage(driver);
        homePage2 = new HomePage(driver2);
        homePage1.openTheApp();
        loginPage2 = new LoginPage(driver2);
        homePage2.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver);
        gamesPage = new GamesPage(driver2);
        driver2.manage().window().maximize();
        wait2 = new WebDriverWait(driver2, Duration.ofSeconds(WAIT_SECONDS));

        homePage1.navigateToLoginPage();
        homePage2.navigateToLoginPage();
        loginPage1.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        loginPage2.login(SECOND_USER_USERNAME, SECOND_USER_PASSWORD);
    }

    @AfterEach
    void cleanUp() {
        quitDriver();
        driver2.quit();
    }

    @Test
    void testPlayingGame() throws InterruptedException {
        myQuizzesPage.clickOnMyQuizzesBtn();
        myQuizzesPage.createLobby();
        gamesPage.navigateToGamesPage();
        gamesPage.joinGameLobby("test7");
        gamesPage.joinGame();
        myQuizzesPage.startGame();
        gamesPage.chooseFirstAnswer();
        myQuizzesPage.checkTheResults();

        WebElement scoreBoard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div")));
        assertEquals("SCOREBOARD", scoreBoard.getText());
    }
}
