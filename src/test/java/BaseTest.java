import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    protected void initializeWebDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
