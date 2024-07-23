import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationPageAndLoginPageTest {

    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;


    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openTheApp();
        driver.manage().window().maximize();
    }

    @Test
    public void userCanRegistrateAndLoginWithTheChosenCredentials() throws InterruptedException {
        registrationPage.clickToSignUp();

        String username = registrationPage.fillTheUserName(System.getenv("USER_NAME"));
        registrationPage.fillTheUserEmail(System.getenv("EMAIL"));
        String password = registrationPage.fillTheUserPassword(System.getenv("PASSWORD"));
        assertTrue(registrationPage.clickToRegistrate());
       loginPage.login(username, password);
        assertEquals("Logout", loginPage.findLogoutBtn().getText());
    }

    @Test
    public void userCanRegistrateOnlyWithProperEmailAddress() throws InterruptedException {
        registrationPage.clickToSignUp();

        String username = registrationPage.fillTheUserName(System.getenv("USER_NAME"));
        registrationPage.fillTheUserEmail("test");
        String password = registrationPage.fillTheUserPassword(System.getenv("PASSWORD"));
        assertTrue(registrationPage.clickToRegistrate());
        loginPage.login(username, password);
        assertNotEquals("Logout", loginPage.findLogoutBtn().getText());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/src/resources/RegistrationData.csv", numLinesToSkip = 1)
    public void createQuizWithValidInputFields(String inputUsername, String inputEmail, String inputPassword) throws InterruptedException {
        registrationPage.clickToSignUp();

        String username = registrationPage.fillTheUserName(inputUsername);
        registrationPage.fillTheUserEmail(inputEmail);
        String password = registrationPage.fillTheUserPassword(inputPassword);
        registrationPage.clickToRegistrate();

        loginPage.login(username, password);

        assertEquals("Logout", loginPage.findLogoutBtn().getText());
    }


    @AfterEach
    public void closeTheApp(){
        driver.quit();
    }
}