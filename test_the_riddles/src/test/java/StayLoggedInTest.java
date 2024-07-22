import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class StayLoggedInTest {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    @BeforeEach
    public  void setUp() {
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        loginPage = new LoginPage(webDriver);
        loginPage.openTheApp();
        webDriver.manage().window().maximize();
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")));
        loginBtn.click();

    }


    @Test
    void testRefreshThePageAndStayedLoggedIn() throws InterruptedException {
        loginPage.login(System.getenv("USER_NAME"), System.getenv( "PASSWORD"));
        Thread.sleep(2000);
        webDriver.navigate().refresh();
       Thread.sleep(2000);
       String actual = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[2]/a/button/span")).getText();
        assertEquals("Logout", actual);
    }

    @Test
    void testOpenNewTabAndStayedLoggedIn() throws InterruptedException {
        loginPage.login(System.getenv("USER_NAME"), System.getenv( "PASSWORD"));
        Thread.sleep(2000);
        ((JavascriptExecutor) webDriver).executeScript("window.open('http://localhost:3000/','_blank');");
        Thread.sleep(2000);
        String actual = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[2]/a/button/span")).getText();
        assertEquals("Logout" ,actual);
    }

    @AfterEach
    public void closeTheApp() {
        webDriver.quit();
    }

}