import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class GamesPage extends BasePage{


    @FindBy(xpath = "/html/body/div/div/div[1]/nav/div/div[1]/ul/li[1]/a/span")
    private WebElement gamesPageBtn;
    @FindBy(xpath = "//div[@class='grow pt-16']/div")
    private List<WebElement> lobbyContainers;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/button")
    private WebElement joinGameBtn;
    @FindBy(id = "2102")
    private WebElement firstAnswerBtn;
    @FindBy(id = "55")
    private WebElement secondAnswerBtn;


    public GamesPage(WebDriver driver) {
        super(driver);
    }


    public void joinGameLobby(String lobbyTitle) {
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfAllElements(lobbyContainers));

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

    public void joinGame() {
        wait.until(ExpectedConditions.elementToBeClickable(joinGameBtn)).click();
    }

    public void navigateToGamesPage()  {
        wait.until(ExpectedConditions.elementToBeClickable(gamesPageBtn));
        gamesPageBtn.click();
    }

    public void chooseFirstAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAnswerBtn)).click();
    }

    public void chooseSecondAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(secondAnswerBtn)).click();
    }

}
