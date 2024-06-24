import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.*;

class RegistratePageTest {

    private WebDriver driver;
    private RegistratePage registratePage;


    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("http://localhost:3000");
        registratePage = new RegistratePage(driver);
        driver.manage().window().maximize();
        assertTrue(registratePage.clickToSignUp());
    }


    @Test
    void verifyUserNameInputEqualsDisplayedValue() {

        WebElement userNameInput = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[1]/input"));

        String expected = registratePage.fillTheUserName("mama");
        String actual = userNameInput.getAttribute("value");

        assertEquals(expected, actual);

    }

    @Test
    void verifyUserEmailInputEqualsDisplayedValue() {
        WebElement userEmailInput = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[2]/input"));

        String expected = registratePage.fillTheUserEmail("hello");
        String actual = userEmailInput.getAttribute("value");

        assertEquals(expected, actual);
    }

    @Test
    void verifyUserPasswordInputEqualsDisplayedValue() {
        WebElement userPasswordInput = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[2]/input"));

        String expected = registratePage.fillTheUserPassword("jelszo");
        String actual = userPasswordInput.getAttribute("value");

        assertTrue(userPasswordInput.isDisplayed());
        assertTrue(userPasswordInput.isEnabled());
    }

    @Test
    void verifySignUpBtnClicked(){
        WebElement registrateBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/button"));

        assertTrue(registrateBtn.isEnabled());
        assertTrue(registrateBtn.isDisplayed());

        registrateBtn.click();
    }

    @AfterEach
    public void closeTheApp(){
        driver.quit();
    }
}