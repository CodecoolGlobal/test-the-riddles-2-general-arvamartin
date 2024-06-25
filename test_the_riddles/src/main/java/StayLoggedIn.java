import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StayLoggedIn {
    WebDriver webDriver;
    WebDriverWait wait;
    String userName = System.getenv("userName");
    String password = System.getenv("password");

    By loginBtn = By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[2]/a[1]/button/span");
    By userNameField = By.xpath("//*[@id=\"user-name\"]");
    By passwordField = By.xpath("//*[@id=\"password\"]");
    By login2Btn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/button");


    public StayLoggedIn(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

public String login() throws InterruptedException {
        webDriver.get("http://localhost:3000/");
        webDriver.manage().window().maximize();
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        webDriver.findElement(userNameField).sendKeys(userName);
        webDriver.findElement(passwordField).sendKeys(password);
    wait.until(ExpectedConditions.elementToBeClickable(login2Btn)).click();
    Thread.sleep(2000);
  return  webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[2]/a/button/span")).getText();
}
}
