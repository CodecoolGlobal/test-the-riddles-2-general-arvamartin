import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class MyQuizzesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By myQuizzesBtn = By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[1]/ul/li[3]/a/span");
    private final By addQuizBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button");
    private final By addQuestionBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/button");
    private final By questionTitleInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[1]/input");
    private final By answerInputOne = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div/div[1]/input");
    private final By getAnswerInputTwo = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div[3]/div/div[1]/input");
    private final By saveBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[4]/button[1]");
    private final By deleteBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button[1]");
    private final By playBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div/button[3]");
    private final By createGameLobbyBtn = By.xpath("/html/body/div/div/button");
    private final By startBtn = By.xpath("/html/body/div/div/div/div[2]/button");
    private final By checkBoxOne = By.xpath("//*[@id=\"checkbox-1\"]");
    private final By checkBoxTwo = By.xpath("//*[@id=\"checkbox-2\"]");
    private final By timer = By.xpath("//*[@id=\"-1time\"]");
    private final By editBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div/button[2]");
    private final By quizTitleInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/input");
    private final By saveNewQuizTitle = By.xpath("/html/body/div/div/div[2]/div/div[2]/button[1]");
    private final By questionBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div/button");
    private final By questionInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[1]/input");
    private final By saveEditedQuestionBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[4]/button[1]");
    private final By joinGameBtn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/button");
    private final By goodAnswerBtn = By.xpath("/html/body/div/div/div[2]/div[1]/button");
    private final By resultBtn = By.xpath("/html/body/div/button");
    private final By lobbyContainer = By.xpath("//div[@class='grow pt-16']/div");
    private final By gameBtn = By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[1]/ul/li[1]/a/span");


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

    public void fillAndSaveTheQuestionModal(String questionTitle, String answerOne, String answerTwo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionTitleInput)).sendKeys(questionTitle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerInputOne)).sendKeys(answerOne);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAnswerInputTwo)).sendKeys(answerTwo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
    }


    public void deleteQuiz() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBtn)).click();
    }

    public void modifyQuizTitle(String newTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(quizTitleInput)).sendKeys(newTitle);
        wait.until(ExpectedConditions.elementToBeClickable(saveNewQuizTitle)).click();
    }

    public void modifyQuestion(String newQuestion)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionInput)).sendKeys(newQuestion);
        wait.until(ExpectedConditions.elementToBeClickable(saveEditedQuestionBtn)).click();
    }


    public void createLobby() {
        clickOnPlayBtn();
        clickOnCreateGameLobbyBtn();
    }

    public void clickOnPlayBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playBtn)).click();
    }

    public void clickOnCreateGameLobbyBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createGameLobbyBtn)).click();
    }

    public String startBtnText() {
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

    public void joinGameLobby(String lobbyTitle) throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(gameBtn)).click();

        List<WebElement> lobbyContainers = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lobbyContainer));

        for (WebElement lobbyContainer : lobbyContainers) {
            WebElement lobbyNameElement = lobbyContainer.findElement(By.xpath(".//span[@class='grow flex align-middle text-lg pl-2 items-center']"));

            if (Objects.equals(lobbyNameElement.getText(), lobbyTitle)) {
                WebElement joinButton = lobbyContainer.findElement(By.xpath(".//button[contains(text(), 'Join')]"));
                joinButton.click();
                return;
            }
        }
        System.out.println("Cannot find the proper lobby");
    }

    public void startGame() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(startBtn)).click();
        } catch (Exception e) {
            System.out.println("Cannot start");
        }
    }

    public void joinGame() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(joinGameBtn)).click();
    }

    public void chooseGoodAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(goodAnswerBtn)).click();
    }

    public void checkTheResults() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(resultBtn)).click();
    }
}
