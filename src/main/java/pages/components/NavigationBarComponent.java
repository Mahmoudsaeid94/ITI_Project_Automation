package pages.components;

import drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.*;
import utils.dataReader.PropertyReader;

public class NavigationBarComponent {
    private final GUIDriver driver;

    public NavigationBarComponent(GUIDriver driver) {
        this.driver = driver;

    }


    private final By homeButton = By.xpath(" //a[normalize-space()='Home']");
    private final By productsButton = By.cssSelector("a[href=\"/products\"]");
    private final By cartButton = By.xpath("//a[normalize-space()='Cart']");
    private final By signUpLoginButton = By.xpath("  //a[normalize-space()='Signup / Login']");
    private final By testCasesButton = By.xpath(" //a[normalize-space()='Test Cases']\n ");
    private final By apiTestingButton = By.xpath(" //a[normalize-space()='API Testing']");
    private final By contactUsButton = By.xpath("//a[normalize-space()='Contact us']");
    private final By logoutButton = By.xpath(" //a[normalize-space()='Logout']");
    private final By deleteAccountButton = By.xpath(" //a[normalize-space()='Delete Account']");
    private final By HomePageLabel = By.cssSelector("header#header > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > a:nth-of-type(1) > img:nth-of-type(1)");
    ;
    private final By videoTutorialsButton = By.xpath(" //a[normalize-space()='Video Tutorials'] ");
    ;
    private final By userLabel = By.tagName("b");


    @Step("Navigate to Home Page")
    public NavigationBarComponent navigate() {
        driver.browser().navigateTo(PropertyReader.getProperty("BASE_URL"));
        return this;
    }

    @Step("Click on Home Button")
    public NavigationBarComponent clickHomeButton() {
        driver.element().click(homeButton);
        return this;
    }

    @Step("Click on products Button")
    public productsPage clickProductsButton() {
        driver.element().click(productsButton);
        return new productsPage(driver);
    }

    @Step("Click on Cart Button")
    public cartPage clickCartButton() {
        driver.element().click(cartButton);
        return new cartPage(driver);

    }

    @Step("Click on SignUp/Login Button")
    public SignupLoginPage clickSignUpLoginButton() {
        driver.element().click(signUpLoginButton);
        return new SignupLoginPage(driver);
    }

    @Step("Click on Logout Button")
    public logout clickLogoutButton() {
        driver.element().click(logoutButton);
        return new logout(driver);
    }

    @Step("Click on Delete Account Button")
    public deleteAccount clickDeleteAccountButton() {
        driver.element().click(deleteAccountButton);
        return new deleteAccount(driver);
    }

    @Step("Click on Test Cases Button")
    public testCases clickTestCasesButton() {
        driver.element().click(testCasesButton);
        return new testCases(driver);
    }

    @Step("Click on API Testing Button")
    public apiTesting clickApiTestingButton() {
        driver.element().click(apiTestingButton);
        return new apiTesting(driver);
    }

    @Step("Click on Contact Us Button")
    public contactUs clickContactUsButton() {
        driver.element().click(contactUsButton);
        return new contactUs(driver);
    }

    @Step("Verify Home Page Label")
    public NavigationBarComponent verifyHomePageLabel() {
        driver.verification().isElementVisible(HomePageLabel);
        return this;

    }

    @Step("Verify User Label")
    public NavigationBarComponent verifyUserLabel(String expectedUsername) {
        String actualUsername = driver.element().getText(userLabel);
        driver.verification().Equals(actualUsername, expectedUsername, "User label does not match expected username.");
        return this;
    }


}