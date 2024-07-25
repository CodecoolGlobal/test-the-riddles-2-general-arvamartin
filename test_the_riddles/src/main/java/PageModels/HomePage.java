package PageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[2]/a[2]/button/span")
    private WebElement singUpBtn;
    private final String BASE_URL = "http://localhost:3000";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openTheApp() {
        driver.get(BASE_URL);
    }

    public void navigateToLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
    }

    public void navigateToRegistrationPage() {
        wait.until(ExpectedConditions.visibilityOf(singUpBtn)).click();
    }
}
