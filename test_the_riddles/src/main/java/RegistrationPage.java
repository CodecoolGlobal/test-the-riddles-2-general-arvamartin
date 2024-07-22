import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By signUpBtn = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[2]/button/span");
    private final By userNameInput = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[1]/input");
    private final By emailInput = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[2]/input");
    private final By passWordInput = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[3]/input");
    private final By registrationBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/button");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickToSignUp() {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtn));
            btn.click();
    }

    public String fillTheUserName(String userName) {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        btn.sendKeys(userName);
        return userName;
    }

    public void fillTheUserEmail(String email) {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        btn.sendKeys(email);
    }

    public String fillTheUserPassword(String password) {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(passWordInput));
        btn.sendKeys(password);
        return password;
    }

    public boolean clickToRegistrate() {
        try {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(registrationBtn));
            btn.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


