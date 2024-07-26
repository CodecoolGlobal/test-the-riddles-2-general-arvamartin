package PageModels;
import Enum.SecondsOfSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuizFormPage extends BasePage{

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/button[2]")
    private WebElement editBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button")
    private WebElement addQuestionBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[1]/input")
    private WebElement questionTitleInput;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div/div[1]/input")
    private WebElement answerInputOne;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/button")
    private WebElement questionNumber;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div[3]/div/div[1]/input")
    private WebElement getAnswerInputTwo;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[2]/div/div[4]/button[1]")
    private WebElement saveBtn;
    @FindBy(id = "checkbox-1")
    private WebElement checkBoxOne;
    @FindBy(id = "checkbox-2")
    private WebElement checkBoxTwo;
    @FindBy(xpath = "//*[@id=\"-1time\"]")
    private WebElement timer;
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

    public QuizFormPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddQuestionBtn() {
        sleep(SecondsOfSleep.TWO_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(addQuestionBtn)).click();
    }

    public void fillAndSaveTheQuestionModal(String questionTitle, String answerOne, String answerTwo) {
        wait.until(ExpectedConditions.visibilityOf(questionTitleInput)).sendKeys(questionTitle);
        wait.until(ExpectedConditions.visibilityOf(answerInputOne)).sendKeys(answerOne);
        wait.until(ExpectedConditions.visibilityOf(getAnswerInputTwo)).sendKeys(answerTwo);
        wait.until(ExpectedConditions.visibilityOf(saveBtn)).click();
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

    public void chooseCheckBoxOne() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxOne)).click();
    }

    public void chooseCheckBoxTwo() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxTwo)).click();
    }

    public boolean isCheckBoxOneSelected() {
        return checkBoxOne.isSelected();
    }

    public boolean isCheckBoxTwoSelected() {
        return checkBoxTwo.isSelected();
    }


    public void setTimer(String time) {
        wait.until(ExpectedConditions.elementToBeClickable(timer)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(timer)).sendKeys(time);
    }

    public void clickOnSaveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }
    public String getTimer() {
        wait.until(ExpectedConditions.visibilityOf(timer));
        return  timer.getAttribute("value");
    }

    public String checkQuestionNumber() {
        return questionNumber.getText();
    }

    public String getQuestionNumberFromField() {
        return questionNumber.getText();
    }

}
