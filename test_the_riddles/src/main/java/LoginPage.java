import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/button");
    private final By logoutBtn = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a/button/span");
    private final String BASE_URL = "http://localhost:3000";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openTheApp(){
        driver.get(BASE_URL);
    }

    public void login(String username, String password) throws InterruptedException {
        fillTheUsername(username);
        fillThePassword(password);
        clickOnLoginBtn();
    }

    public void fillTheUsername(String username) throws InterruptedException {
        Thread.sleep(3000);
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        input.sendKeys(username);
    }

    public void fillThePassword(String password) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        input.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        WebElement btn = driver.findElement(loginBtn);
        btn.click();
    }

    public WebElement findLogoutBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
    }


}
