package PageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private final int WAIT_SECONDS = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS));
        PageFactory.initElements(driver, this);
    }

    protected void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted", e);
        }
    }
}
