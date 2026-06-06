package pages;

import drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.components.NavigationBarComponent;

public class PaymentPage {
    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;


    public PaymentPage(GUIDriver driver) {
        this.driver = driver;
        this.navigationBarComponent = new NavigationBarComponent(driver);
    }

    private String checkoutEndpoint = "/payment";

    private final By NameOnCard = By.name("name_on_card");
   private final By cardNumber = By.name("card_number");
   private final By cvc= By.name("cvc");
    private final By expiryMonth = By.name("expiry_month");
    private final By expiryYear = By.name("expiry_year");
    private final By payButton = By.id("submit");
    private final By orderConfirmation = By.cssSelector("h2[data-qa='order-places']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");
private final By paymentSuccessMessage = By.cssSelector("h2[data-qa='order-placed']");
    private final By FailureMessage = By.cssSelector("div#success_message > div:nth-of-type(1) > p:nth-of-type(1)");




     @Step("Fill card info")
    public PaymentPage fillCardInfo(String nameOnCard,
                                    String cardNumber,
                                    String cvc,
                                    String expiryMonth,
                                    String expiryYear)
     {

        driver.element().type(NameOnCard, nameOnCard);
        driver.element().type(this.cardNumber, cardNumber);
        driver.element().type(this.cvc, cvc);
        driver.element().type(this.expiryMonth, expiryMonth);
        driver.element().type(this.expiryYear, expiryYear);
        return this;
    }

@Step
public PaymentPage ClickpayButton() {
    driver.element().click(payButton);
    return this;
}

    @Step("Verify payment success message")
    public PaymentPage verifyPaymentSuccessMessage(String expectedMessage) {
        driver.verification().Equals(driver.element().getText(paymentSuccessMessage), expectedMessage, "payment Success Message");
        return this;
    }
@Step("Verify payment failure message")
    public CheckOutPage verifyPaymentFailureMessage(String expectedMessage) {
String actualMessage = driver.element().getText(FailureMessage);
        driver.verification().Equals(actualMessage, expectedMessage, "Error message for invalid does not match expected.");
        return new CheckOutPage(driver);}
}

