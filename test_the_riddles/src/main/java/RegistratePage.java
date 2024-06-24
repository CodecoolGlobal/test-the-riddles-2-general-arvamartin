import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistratePage {

    WebDriver driver;
    WebDriverWait wait;

    By signUpBtn = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/a[2]/button/span");
    By userNameInput = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[1]/input");
    By emailInput = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[2]/input");
    By passWordInput = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[3]/input");
    By registrateBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/button");

    public RegistratePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public boolean clickToSignUp(){
        try {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtn));
            btn.click();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String fillTheUserName(String userName) {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        btn.sendKeys(userName);
        return userName;
    }

    public String fillTheUserEmail(String email) {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        btn.sendKeys(email);
        return email;
    }
    public String fillTheUserPassword(String password) {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(passWordInput));
        btn.sendKeys(password);
        return password;
    }

    public boolean clickToRegistrate(){
        try {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(registrateBtn));
            btn.click();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}


