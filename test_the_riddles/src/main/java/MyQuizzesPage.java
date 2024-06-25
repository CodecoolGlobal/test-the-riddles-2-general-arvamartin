import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    By answerInputOne = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div/div[1]/input");
    By getAnswerInputTwo = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div[3]/div/div[1]/input");
    By saveBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[4]/button[1]");
    By deleteBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button[1]");
    By playBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div/button[3]");
    By createGameLobbyBtn = By.xpath("/html/body/div/div/button");
    By startBtn = By.xpath("/html/body/div/div/div/div[2]/button");
    By checkBoxOne = By.xpath("//*[@id=\"checkbox-1\"]");
    By checkBoxTwo = By.xpath("//*[@id=\"checkbox-2\"]");
    By timer = By.xpath("//*[@id=\"-1time\"]");


    public MyQuizzesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickOnMyQuizzesBtn() throws InterruptedException {
        Thread.sleep(2000);
        WebElement btn = driver.findElement(myQuizzesBtn);
        btn.click();
    }

    public void clickOnAddQuizBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addQuizBtn)).click();
    }

    public void clickOnAddQuestionBtn() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addQuestionBtn)).click();

    }

    public void fillAndSaveTheQuestionModal (String questionTitle, String answerOne, String answerTwo){
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionTitleInput)).sendKeys(questionTitle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerInputOne)).sendKeys(answerOne);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAnswerInputTwo)).sendKeys(answerTwo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
    }


    public void deleteQuiz(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBtn)).click();
    }


    public void createLobby(){
        clickOnPlayBtn();
        clickOnCreateGameLobbyBtn();
    }

    public void clickOnPlayBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(playBtn)).click();
    }

    public void clickOnCreateGameLobbyBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createGameLobbyBtn)).click();
    }

    public String startBtnText(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(startBtn)).getText();
    }


    public void chooseCheckBoxOne() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxOne)).click();
    }

    public void chooseCheckBoxTwo() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxTwo)).click();
    }

    public void setTimer(String time) {
        wait.until(ExpectedConditions.elementToBeClickable(timer)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(timer)).sendKeys(time);
    }
}
