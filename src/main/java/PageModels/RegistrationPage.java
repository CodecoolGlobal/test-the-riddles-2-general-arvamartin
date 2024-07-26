package PageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div[2]/div[1]/input")
    private WebElement userNameInput;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div[2]/div[2]/input")
    private WebElement emailInput;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div[2]/div[3]/input")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/button")
    private WebElement registrationBtn;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String fillTheUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.sendKeys(userName);
        return userName;
    }

    public void fillTheUserEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public String fillTheUserPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        return password;
    }

    public boolean clickToRegister() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(registrationBtn)).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


