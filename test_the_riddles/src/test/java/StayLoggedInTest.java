import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class StayLoggedInTest {

    private WebDriver webDriver;
    private StayLoggedIn stayLoggedIn;
    private WebDriverWait wait;
    @BeforeEach
    public  void setUp() {
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        stayLoggedIn = new StayLoggedIn(webDriver,wait);
    }


    @Test
    void testRefreshThePageAndStayedLoggedIn() throws InterruptedException {
        String result = stayLoggedIn.login();
       webDriver.navigate().refresh();
       Thread.sleep(2000);
       String actual = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[2]/a/button/span")).getText();
        assertEquals(actual,result);
    }

    @Test
    void testOpenNewTabAndStayedLoggedIn() throws InterruptedException {
        String result = stayLoggedIn.login();
        ((JavascriptExecutor) webDriver).executeScript("window.open('http://localhost:3000/','_blank');");
        Thread.sleep(2000);
        String actual = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[2]/a/button/span")).getText();
        assertEquals(actual,result);
    }

}