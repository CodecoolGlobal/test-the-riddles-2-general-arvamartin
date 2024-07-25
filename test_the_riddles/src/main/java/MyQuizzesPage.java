import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyQuizzesPage extends BasePage{


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/div/div[1]/ul/li[3]/a/span")
    private WebElement myQuizzesBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button")
    private WebElement addQuizBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/button")
    private WebElement addQuestionBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[1]/input")
    private WebElement questionTitleInput;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div/div[1]/input")
    private WebElement answerInputOne;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div[3]/div/div[1]/input")
    private WebElement getAnswerInputTwo;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[4]/button[1]")
    private WebElement saveBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[1]/button[1]")
    private WebElement deleteBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/button[3]")
    private WebElement playBtn;
    @FindBy(xpath = "/html/body/div/div/button")
    private WebElement createGameLobbyBtn;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/button")
    private WebElement startBtn;
    @FindBy(xpath = "//*[@id=\"checkbox-1\"]")
    private WebElement checkBoxOne;
    @FindBy(xpath = "//*[@id=\"checkbox-2\"]")
    private WebElement checkBoxTwo;
    @FindBy(xpath = "//*[@id=\"-1time\"]")
    private WebElement timer;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/button[2]")
    private WebElement editBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[1]/input")
    private WebElement quizTitleInput;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/button[1]")
    private WebElement saveNewQuizTitle;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/button")
    private WebElement questionBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[1]/input")
    private WebElement questionInput;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[4]/button[1]")
    private WebElement saveEditedQuestionBtn;
    @FindBy(xpath = "/html/body/div/button")
    private WebElement resultBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/button/text()[1]")
    private WebElement questionNumber;


    public MyQuizzesPage(WebDriver driver) {
        super(driver);
    }

    public boolean testResponsiveLayout(Dimension dimension) {
        driver.manage().window().setSize(dimension);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        boolean isTaskBoxCollapsed = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]")).isDisplayed();
        if (!isTaskBoxCollapsed) {
            System.err.println("Game list is not collapsed!");
            return false;
        }
        return true;
    }

    public void clickOnMyQuizzesBtn() {
        sleep(SecondsOfSleep.TWO_SECONDS.getMilliseconds());
        wait.until(ExpectedConditions.elementToBeClickable(myQuizzesBtn)).click();
    }

    public void clickOnAddQuizBtn() {
        wait.until(ExpectedConditions.visibilityOf(addQuizBtn)).click();
    }

    public void clickOnAddQuestionBtn() {
        sleep(SecondsOfSleep.TWO_SECONDS.getMilliseconds());
        wait.until(ExpectedConditions.visibilityOf(addQuestionBtn)).click();
    }

    public void fillAndSaveTheQuestionModal(String questionTitle, String answerOne, String answerTwo) {
        wait.until(ExpectedConditions.visibilityOf(questionTitleInput)).sendKeys(questionTitle);
        wait.until(ExpectedConditions.visibilityOf(answerInputOne)).sendKeys(answerOne);
        wait.until(ExpectedConditions.visibilityOf(getAnswerInputTwo)).sendKeys(answerTwo);
        wait.until(ExpectedConditions.visibilityOf(saveBtn)).click();
    }

    public void deleteQuiz() {
        wait.until(ExpectedConditions.visibilityOf(deleteBtn)).click();
    }

    public void modifyQuizTitle(String newTitle) {
        wait.until(ExpectedConditions.visibilityOf(editBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(quizTitleInput)).sendKeys(newTitle);
        wait.until(ExpectedConditions.elementToBeClickable(saveNewQuizTitle)).click();
    }

    public void modifyQuestion(String newQuestion) {
        wait.until(ExpectedConditions.visibilityOf(editBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(questionBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(questionInput)).sendKeys(newQuestion);
        wait.until(ExpectedConditions.elementToBeClickable(saveEditedQuestionBtn)).click();
    }

    public void createLobby() {
        clickOnPlayBtn();
        clickOnCreateGameLobbyBtn();
    }

    public void clickOnPlayBtn() {
        wait.until(ExpectedConditions.visibilityOf(playBtn)).click();
    }

    public void clickOnCreateGameLobbyBtn() {
        wait.until(ExpectedConditions.visibilityOf(createGameLobbyBtn)).click();
    }

    public String startBtnText() {
        return wait.until(ExpectedConditions.visibilityOf(startBtn)).getText();
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

    public void startGame() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(startBtn)).click();
        } catch (Exception e) {
            System.out.println("Cannot start");
        }
    }

    public void checkTheResults() {
        sleep(SecondsOfSleep.THREE_SECONDS.getMilliseconds());
        wait.until(ExpectedConditions.elementToBeClickable(resultBtn)).click();
    }

    public String checkQuestionNumber() {
        return  questionNumber.getText();
    }
}
