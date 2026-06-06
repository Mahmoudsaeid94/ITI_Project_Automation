package pages;

import drivers.GUIDriver;

import pages.components.NavigationBarComponent;
import utils.dataReader.PropertyReader;

import io.qameta.allure.Step;

import org.openqa.selenium.By;


public class SignupLoginPage {
    private GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;
    public SignupLoginPage(GUIDriver driver) {
        this.driver = driver;

        this.navigationBarComponent = new NavigationBarComponent(driver);

    }

    private final By loginEmailField = By.cssSelector("[data-qa='login-email']");
    private final By loginPasswordField = By.cssSelector("[data-qa='login-password']");
    private final By loginButton = By.cssSelector("[data-qa='login-button']");
    private final By loginErrorMessage = By.cssSelector(".login-form p");
    private final By loginLabel = By.xpath("//a[contains(.,'Logged in as')]");
    private final By SignUpNameField = By.cssSelector("[data-qa='signup-name']");
    private final By SignUpEmailField = By.cssSelector("[data-qa='signup-email']");
    private final By SignUpButton = By.cssSelector("[data-qa='signup-button']");
    private final By SignUpErrorMessage = By.cssSelector(".signup-form p");
    private final By signupLabel = By.cssSelector(".signup-form > h2");
    private final By SubscriptionLabel = By.xpath("//h2[normalize-space()='Subscription']");
    private final By SubscriptionEmailField = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By SubscriptionSuccessMessage = By.cssSelector(".alert-success");


    @Step("Navigate to Signup/Login Page")
    public SignupLoginPage navigate() {
        driver.browser().navigateTo(PropertyReader.getProperty("BASE_URL") + "/login");
        return this;
    }

    @Step("Navigate to Signup Page")
    public SignupLoginPage navigateToSignupPage() {
        driver.browser().navigateTo(PropertyReader.getProperty("BASE_URL") + "/signup");
        return this;
    }

    @Step("Login --> Email ")
    public SignupLoginPage enterLoginEmail(String email) {
        driver.element().type(loginEmailField, email);
        return this;
    }

    @Step("Login --> Password")
    public SignupLoginPage enterLoginPassword(String password) {
        driver.element().type(loginPasswordField, password);
        return this;
    }

    @Step("Click on Login Button")
    public SignupLoginPage clickLoginButton() {
        driver.element().click(loginButton);
        return this;
    }


//    ----------------------------


    @Step("Sign up --> Name")
    public SignupLoginPage enterSignUpName(String name) {
        driver.element().type(SignUpNameField, name);
        return this;
    }

    @Step("Sign up -->Email")
    public SignupLoginPage enterSignUpEmail(String email) {
        driver.element().type(SignUpEmailField, email);
        return this;
    }

    @Step("Click on Sign Up Button")
    public SignupLoginPage clickSignUpButton() {
        driver.element().click(SignUpButton);
        return new SignupLoginPage(driver);
    }


    @Step("Get Login Error Message")
    public String getLoginErrorMessage() {
        return driver.element().getText(loginErrorMessage);
    }

    @Step("Get Sign Up Error Message")
    public String getSignUpErrorMessage() {
        return driver.element().getText(SignUpErrorMessage);
    }

    @Step("Get Sign Up Label")
    public String getSignUpLabel() {
        return driver.element().getText(signupLabel);
    }




    @Step("Enter Subscription Email")
    public SignupLoginPage enterSubscriptionEmail(String email) {
        driver.element().type(SubscriptionEmailField, email);
        return this;
    }

    @Step("Click on Subscribe Button")
    public SignupLoginPage clickSubscribeButton() {
        driver.element().click(subscribeButton);

        return this;
    }

    @Step("Subscriba Mail Success Message")
    public String getSubscriptionSuccessMessage() {
        return driver.element().getText(SubscriptionSuccessMessage);
    }

    @Step(" verify Signup/Login Page Label")
    public SignupLoginPage verifySignupLoginPageLabel() {
        driver.verification().isElementVisible(signupLabel);
        return this;
    }

    @Step(" verify Login Page Label")
    public SignupLoginPage verifyLoginPageLabel() {
        driver.verification().isElementVisible(loginLabel);
        return this;
    }
    @Step("verify Error Message for Existing Email")
    public SignupLoginPage verifyErrorMessageForExistingEmail(String expectedMessage) {
        String actualMessage = driver.element().getText(SignUpErrorMessage);
        driver.verification().Equals(actualMessage, expectedMessage, "Error message for existing email does not match expected.");
        return this;
    }

    @Step("verify Error Message for Invalid Login")
    public SignupLoginPage verifyErrorMessageForInvalidLogin(String expectedMessage) {
        String actualMessage = driver.element().getText(loginErrorMessage);
        driver.verification().Equals(actualMessage, expectedMessage, "Error message for invalid login does not match expected.");
        return this;
    }

    @Step("Verify Subscription Title")

    public SignupLoginPage verifySubscriptionTitle() {
        driver.verification().isElementVisible(SubscriptionLabel);
        return this;
    }

}



