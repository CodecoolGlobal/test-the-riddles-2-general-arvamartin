package PageModels;

import Enum.SecondsOfSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyQuizzesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/div/div[1]/ul/li[3]/a/span")
    private WebElement myQuizzesBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button")
    private WebElement addQuizBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[1]/button[1]")
    private WebElement deleteBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/button[3]")
    private WebElement playBtn;
    @FindBy(xpath = "/html/body/div/div/button")
    private WebElement createGameLobbyBtn;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/button")
    private WebElement startBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/button[2]")
    private WebElement editBtn;
    @FindBy(xpath = "/html/body/div/button")
    private WebElement resultBtn;



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
        sleep(SecondsOfSleep.TWO_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(myQuizzesBtn)).click();
    }

    public void clickOnAddQuizBtn() {
        wait.until(ExpectedConditions.visibilityOf(addQuizBtn)).click();
    }

    public void deleteQuiz() {
        wait.until(ExpectedConditions.visibilityOf(deleteBtn)).click();
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


    public void startGame() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(startBtn)).click();
        } catch (Exception e) {
            System.out.println("Cannot start");
        }
    }

    public void checkTheResults() {
        sleep(SecondsOfSleep.THREE_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(resultBtn)).click();
    }





}
