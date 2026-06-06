package tests;

import drivers.GUIDriver;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupLoginPage;
import pages.components.NavigationBarComponent;
import utils.TimeManager;
import utils.dataReader.JsonReader;

@Epic("Automation Exercise")
@Story("User login test cases")
@Severity(SeverityLevel.NORMAL)
@Owner("Mahmoud Saeid ITI")

public class LoginTest extends BaseTest {
    String timestamp = TimeManager.getTimestampP();


    @Test
    public void ValidDateLoginTc() {
        new SignupLoginPage(driver).navigate().
                enterLoginEmail(testData.getJsonData("email") + timestamp + "@gmail.com").
                enterLoginPassword(testData.getJsonData("password")).
                clickLoginButton().verifyLoginPageLabel();
    }


    @Test(groups = {"Invalid"})
    public void LoginWithInvalidPasswordShowError() {

        new SignupLoginPage(driver).navigate().
                enterLoginEmail("iti@mail.com").
                enterLoginPassword("123400056").
                clickLoginButton().verifyErrorMessageForInvalidLogin(testData.getJsonData("errorMessageForInvalidLogin"));
    }

    @Test(groups = {"Invalid"})
    public void LoginWithInvalidEmailShowError() {

        new SignupLoginPage(driver).navigate().
                enterLoginEmail("i00000i@mail.com").
                enterLoginPassword("123456").
                clickLoginButton().verifyErrorMessageForInvalidLogin(testData.getJsonData("errorMessageForInvalidLogin"));
    }

    @BeforeClass(alwaysRun = true)
    protected void preCondition() {
        testData = new JsonReader("Login-data");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new GUIDriver();
        new NavigationBarComponent(driver).navigate();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quitDriver();
    }

}





