import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id ="user-name" )
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div[2]/button")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[2]/a/button/span")
    private WebElement logoutBtn;
    private final String BASE_URL = "http://localhost:3000";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
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
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
    }

    public void fillThePassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public WebElement findLogoutBtn() {
        return wait.until(ExpectedConditions.visibilityOf(logoutBtn));
    }


}
