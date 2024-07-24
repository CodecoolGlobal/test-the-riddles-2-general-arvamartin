import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{


    @FindBy(id ="user-name" )
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div[2]/button")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[2]/a/button/span")
    private WebElement logoutBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password) throws InterruptedException {
        fillTheUsername(username);
        fillThePassword(password);
        clickOnLoginBtn();
    }

    public void fillTheUsername(String username) throws InterruptedException {
        sleep(3000);
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
