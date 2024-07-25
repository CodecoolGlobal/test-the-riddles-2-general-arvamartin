import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final int WAIT_SECONDS = 3;

    protected void initializeWebDriver() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
