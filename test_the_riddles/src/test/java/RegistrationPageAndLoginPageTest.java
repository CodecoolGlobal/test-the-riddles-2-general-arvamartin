import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationPageAndLoginPageTest {

    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;


    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("http://localhost:3000");
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        assertTrue(registrationPage.clickToSignUp());
    }

    @Test
    public void UserCanRegistrateAndLoginWithTheChosenCredentials() throws InterruptedException {

        assertTrue(registrationPage.clickToSignUp());

        String username = registrationPage.fillTheUserName("test");
        registrationPage.fillTheUserEmail("test");
        String password = registrationPage.fillTheUserPassword("test");

        assertTrue(registrationPage.clickToRegistrate());

        loginPage.fillTheUsername(username);
        loginPage.fillThePassword(password);
        loginPage.clickOnLoginBtn();
        
        assertEquals("Logout", loginPage.findLogoutBtn().getText());
    }


    @AfterEach
    public void closeTheApp(){
        driver.quit();
    }
}