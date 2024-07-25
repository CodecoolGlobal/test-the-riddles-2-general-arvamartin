import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationPageTest extends BaseTest{

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
    public void userCanRegistrateAndLoginWithTheChosenCredentials() throws InterruptedException {
        String username = registrationPage.fillTheUserName(System.getenv("USER_NAME"));
        registrationPage.fillTheUserEmail(System.getenv("EMAIL"));
        String password = registrationPage.fillTheUserPassword(System.getenv("PASSWORD"));
        assertTrue(registrationPage.clickToRegistrate());
       loginPage.login(username, password);
        assertEquals("Logout", loginPage.findLogoutBtn().getText());
    }

    @Test
    public void userCanRegistrateOnlyWithProperEmailAddress() throws InterruptedException {
        String username = registrationPage.fillTheUserName(System.getenv("USER_NAME"));
        registrationPage.fillTheUserEmail("test");
        String password = registrationPage.fillTheUserPassword(System.getenv("PASSWORD"));
        assertTrue(registrationPage.clickToRegistrate());
        loginPage.login(username, password);
        assertNotEquals("Logout", loginPage.findLogoutBtn().getText());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/src/resources/RegistrationData.csv", numLinesToSkip = 1)
    public void RegistrateWithValidInputFields(String inputUsername, String inputEmail, String inputPassword) throws InterruptedException {

        String username = registrationPage.fillTheUserName(inputUsername);
        registrationPage.fillTheUserEmail(inputEmail);
        String password = registrationPage.fillTheUserPassword(inputPassword);
        registrationPage.clickToRegistrate();

        loginPage.login(username, password);

        assertEquals("Logout", loginPage.findLogoutBtn().getText());
    }



}