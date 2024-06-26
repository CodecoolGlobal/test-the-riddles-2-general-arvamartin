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
    By editBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div/button[2]");
    By quizTitleInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/input");
    By saveNewQuizTitle = By.xpath("/html/body/div/div/div[2]/div/div[2]/button[1]");
    By questionBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div/button");
    By questionInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[1]/input");
    By saveEditedQuestionBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[4]/button[1]");
    By gameBtn = By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[1]/ul/li[1]/a/span");
    By joinGameLobbyBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/button");
    By joinGameBtn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/button");
    By goodAnswerBtn = By.xpath("//*[@id=\"1\"]/p");



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

    public void modifyQuizTitle(String newTitle){
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(quizTitleInput)).sendKeys(newTitle);
        wait.until(ExpectedConditions.elementToBeClickable(saveNewQuizTitle)).click();
    }

    public void modifyQuestion(String newQuestion) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionInput)).sendKeys(newQuestion);
        wait.until(ExpectedConditions.elementToBeClickable(saveEditedQuestionBtn)).click();
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

    public void joinGameLobby() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(gameBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(joinGameLobbyBtn)).click();
    }

    public void  startGame() {
        wait.until(ExpectedConditions.elementToBeClickable(startBtn)).click();
    }

    public void joinGame() {
        wait.until(ExpectedConditions.elementToBeClickable(joinGameBtn)).click();
    }

    public void chooseGoodAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(goodAnswerBtn)).click();
    }
}
