import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[2]/a[2]/button/span")
    private WebElement singUpBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void navigateToLoginPage() {
        loginBtn.click();
    }

    public void navigateToRegistrationPage() {
        singUpBtn.click();
    }
}
