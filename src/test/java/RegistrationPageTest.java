import PageModels.HomePage;
import PageModels.LoginPage;
import PageModels.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationPageTest extends BaseTest {

    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        initializeWebDriver();
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.openTheApp();
        homePage.navigateToRegistrationPage();
    }

    @AfterEach
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void userCanRegisterAndLoginWithTheChosenCredentials() {
        String username = registrationPage.fillTheUserName(System.getenv("USER_NAME"));
        registrationPage.fillTheUserEmail(System.getenv("EMAIL"));
        String password = registrationPage.fillTheUserPassword(System.getenv("PASSWORD"));
        registrationPage.clickToRegister();
        loginPage.login(username, password);
        String actual = loginPage.getLogoutBtnText();
        assertEquals("Logout", actual);
    }

    @Test
    void userCanRegisterWithValidCredentials() {
        registrationPage.fillTheUserName(System.getenv("USER_NAME"));
        registrationPage.fillTheUserEmail(System.getenv("EMAIL"));
        registrationPage.fillTheUserPassword(System.getenv("PASSWORD"));
        registrationPage.clickToRegister();
        homePage.navigateToLoginPage();
        String actual = loginPage.getLoginBtnText();
        assertEquals("LOGIN", actual);
    }

    @Test
    public void userCanRegisterOnlyWithProperEmailAddress() {
        String username = registrationPage.fillTheUserName(System.getenv("USER_NAME"));
        registrationPage.fillTheUserEmail("test");
        String password = registrationPage.fillTheUserPassword(System.getenv("PASSWORD"));
        assertTrue(registrationPage.clickToRegister());
        loginPage.login(username, password);
        String actual = loginPage.getLogoutBtnText();
        assertNotEquals("Logout", actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/src/resources/RegistrationData.csv", numLinesToSkip = 1)
    public void userCanRegisterWithSpecialCharacters(String inputUsername, String inputEmail, String inputPassword) {
        String username = registrationPage.fillTheUserName(inputUsername);
        registrationPage.fillTheUserEmail(inputEmail);
        String password = registrationPage.fillTheUserPassword(inputPassword);
        registrationPage.clickToRegister();
        loginPage.login(username, password);
        String actual = loginPage.getLogoutBtnText();
        assertEquals("Logout", actual);
    }
}