package tests;

import drivers.GUIDriver;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupLoginPage;
import pages.SignupPage;

import pages.components.NavigationBarComponent;
import utils.dataReader.JsonReader;
import utils.TimeManager;


@Epic("Automation Exercise")
@Story("User Registeration test cases")
@Severity(SeverityLevel.CRITICAL)
@Owner("Mahmoud Saeid ITI")
public class RegisterTest extends BaseTest {
    String timestamp = TimeManager.getTimestampP();

    @Test
    public void ValidDateSignUpTc() {

        new SignupLoginPage(driver).navigate().
                enterSignUpName(testData.getJsonData("name")).

                enterSignUpEmail(testData.getJsonData("email") + timestamp + "@gmail.com").
                clickSignUpButton();
        new SignupPage(driver).
                fillRegisterationForm(
                        testData.getJsonData("titleMale")
                        , testData.getJsonData("password")
                        , testData.getJsonData("day")
                        , testData.getJsonData("month")
                        , testData.getJsonData("year")
                        , testData.getJsonData("firstName")
                        , testData.getJsonData("lastName")
                        , testData.getJsonData("company")
                        , testData.getJsonData("address1")
                        , testData.getJsonData("address2")
                        , testData.getJsonData("country")
                        , testData.getJsonData("state")
                        , testData.getJsonData("city")
                        , testData.getJsonData("zipcode")
                        , testData.getJsonData("mobileNumber")).
                clickCreateAccountButton().

                verifyAccountCreated();

    }

    @Test(groups = {"Invalid"})    @Description("Create account Invalid email")

    public void createAccountExistingEmailShowError() {

        new SignupLoginPage(driver).navigate().
                enterSignUpName(testData.getJsonData("name123")).
                enterSignUpEmail(testData.getJsonData("email123")).
                clickSignUpButton().
                verifyErrorMessageForExistingEmail(testData.getJsonData("errorMessageForExistingEmail"));
    }

    @Test(groups = {"Invalid"})
    @Description("fill Registeration Form with invalid data")
    public void InValidDateSignUpTc() {

        new SignupLoginPage(driver).navigate().
                enterSignUpName(testData.getJsonData("name123")).

                enterSignUpEmail(testData.getJsonData("email") + timestamp + "@gmail.com").
                clickSignUpButton();
        new SignupPage(driver).
                fillRegisterationForm(
                        testData.getJsonData("titleMale")
                        , testData.getJsonData("password")
                        , testData.getJsonData("day")
                        , testData.getJsonData("month")
                        , testData.getJsonData("year")
                        , testData.getJsonData("firstName1")
                        , testData.getJsonData("lastName1")
                        , testData.getJsonData("company1")
                        , testData.getJsonData("address11")
                        , testData.getJsonData("address21")
                        , testData.getJsonData("country1")
                        , testData.getJsonData("state1")
                        , testData.getJsonData("city1")
                        , testData.getJsonData("zipcode1")
                        , testData.getJsonData("mobileNumber1")).
                clickCreateAccountButton().

                verifyAccountCreated();

    }

    @Test(groups = {"Invalid"})
    @Description("Create account with Arabic Name")
    public void createAccountWithARNameShowError() {

        new SignupLoginPage(driver).navigate().
                enterSignUpName(testData.getJsonData("name1")).
                enterSignUpEmail(testData.getJsonData("emailDomain1")).
                clickSignUpButton().verifyErrorMessageForInvalidLogin(testData.getJsonData("errorMessageForInvalidLogin"));
    }
    @BeforeClass(alwaysRun = true)

    protected void preCondition() {
        testData = new JsonReader("register-data");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {        driver = new GUIDriver();
        new NavigationBarComponent(driver).navigate();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quitDriver();
    }

}
