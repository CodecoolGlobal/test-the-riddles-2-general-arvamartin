package PageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Enum.SecondsOfSleep;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private final int WAIT_SECONDS = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS));
        PageFactory.initElements(driver, this);
    }

    protected void sleep(SecondsOfSleep secondsOfSleep) {
        try {
            Thread.sleep(secondsOfSleep.getMilliseconds());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted", e);
        }
    }

    protected WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickWhenVisible(WebElement element) {
        waitUntilVisible(element).click();
    }

    protected void clickWhenClickable(WebElement element) {
       waitUntilClickable(element).click();
    }



}
