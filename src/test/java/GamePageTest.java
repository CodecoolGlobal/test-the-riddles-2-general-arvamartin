import PageModels.GamesPage;
import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.MyQuizzesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePageTest {

    private WebDriver driver1;
    private WebDriver driver2;
    private LoginPage loginPage1;
    private LoginPage loginPage2;
    private HomePage homePage1;
    private HomePage homePage2;
    private MyQuizzesPage myQuizzesPage;
    private GamesPage gamesPage;


    @BeforeEach
    public void setUp() {
        driver1 = new EdgeDriver();
        driver2 = new EdgeDriver();
        loginPage1 = new LoginPage(driver1);
        homePage1 = new HomePage(driver1);
        homePage2 = new HomePage(driver2);
        homePage1.openTheApp();
        loginPage2 = new LoginPage(driver2);
        homePage2.openTheApp();
        myQuizzesPage = new MyQuizzesPage(driver1);
        gamesPage = new GamesPage(driver2);
        driver2.manage().window().maximize();
        homePage1.navigateToLoginPage();
        homePage2.navigateToLoginPage();
        loginPage1.login(System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        loginPage2.login(System.getenv("USER_NAME2"), System.getenv("PASSWORD2"));
    }

    @AfterEach
    void cleanUp() {
        driver1.quit();
        driver2.quit();
    }

    @Test
    void testPlayingGame() {
        homePage1.navigateToMyQuizPage();
        homePage2.navigateToMyQuizPage();
        myQuizzesPage.createLobby();
        gamesPage.navigateToGamesPage();
        gamesPage.joinGameLobby("test16");
        gamesPage.joinGame();
        myQuizzesPage.startGame();
        gamesPage.chooseFirstAnswer();
        myQuizzesPage.checkTheResults();
        String actual = gamesPage.getScoreBoardText();
        assertEquals("SCOREBOARD", actual);
    }
}
