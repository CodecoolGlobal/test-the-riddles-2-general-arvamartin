package PageModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[2]/a[1]/button/span")
    private WebElement loginBtn;
    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[2]/a[2]/button/span")
    private WebElement singUpBtn;
    private final String BASE_URL = "http://localhost:3000";
    private final String LOGIN_PAGE_URL = "http://localhost:3000/login";
    private final String REGISTRATION_PAGE_URL = "http://localhost:3000/register";
    private final String MY_QUIZ_PAGE_URL = "http://localhost:3000/quiz/my";



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openTheApp() {
        driver.get(BASE_URL);
    }

    public void navigateToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    public void navigateToRegistrationPage() {
        driver.get(REGISTRATION_PAGE_URL);
    }
    public void navigateToMyQuizPage() {
        driver.get(MY_QUIZ_PAGE_URL);
    }
}
