import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyQuizzesPage {

    WebDriver driver;
    WebDriverWait wait;

    By myQuizzesBtn = By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[1]/ul/li[3]/a/span");
    By addQuizBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button");
    By addQuestionBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/button");
    By questionTitleInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[1]/input");


    public MyQuizzesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickOnMyQuizzesBtn() throws InterruptedException {
        Thread.sleep(1000);
        WebElement btn = driver.findElement(myQuizzesBtn);
        btn.click();
    }

    public void clickOnAddQuizBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addQuizBtn)).click();
    }

    public void clickOnAddQuestionBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/button"))).click();
    }


    public void createAQuestion(String questionTitle){
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionTitleInput)).sendKeys(questionTitle);
    }


}
