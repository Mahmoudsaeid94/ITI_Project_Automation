package tests;

import drivers.GUIDriver;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.components.NavigationBarComponent;
import utils.TimeManager;
import utils.dataReader.JsonReader;
@Epic("Automation Exercise")
@Story("User payment Test cases")
@Severity(SeverityLevel.CRITICAL)
@Owner("Mahmoud Saeid ITI")
public class PaymentTest  extends BaseTest {

        String timestamp = TimeManager.getTimestampP();

        @Test
        public void registerNewAccount(){
            new SignupLoginPage(driver).navigate().
                    enterSignUpName(testData.getJsonData("name")).

                    enterSignUpEmail(testData.getJsonData("email") + timestamp + "@ahdgkiil.com").
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
            new SignupPage(driver).ClickContinueButton().navigationBarComponent.clickLogoutButton();
        }



        @Test(dependsOnMethods = "registerNewAccount")

        public void ValidDateLoginTc() {
            new SignupLoginPage(driver).navigate().
                    enterLoginEmail(testData.getJsonData("email") + timestamp + "@ahdgkiil.com").
                    enterLoginPassword(testData.getJsonData("password")).
                    clickLoginButton().
                    verifyLoginPageLabel();
        }




    @Test(dependsOnMethods ={"ValidDateLoginTc","registerNewAccount"} )
    public void verifyProductDetails() {
        new productsPage(driver).navigate().
                clickOnViewProduct(testData.getJsonData("products4.name")).
                verifyProductDetails(testData.getJsonData("products4.name"), testData.getJsonData("products4.price")); }

        @Test(dependsOnMethods = {"verifyProductDetails","ValidDateLoginTc","registerNewAccount"})
        public void addProductToCartTest() {
            new productsPage(driver).navigate().clickOnAddToCart(testData.getJsonData("products4.name"))
                    .validateItemAddedLabel(testData.getJsonData("messages.cartAdded")).
                    clickOnViewCart().
                    verifyProductDetaOnCart(testData.getJsonData("products4.name"),
                            testData.getJsonData("products4.price"),
                            testData.getJsonData("products4.quantity"),
                            testData.getJsonData("products4.total"));

        }



        @Test(dependsOnMethods ={"verifyProductDetails","addProductToCartTest","ValidDateLoginTc","registerNewAccount"} )
        public void CheckOut() {
            new cartPage(driver).clickProceedToCheckOut().verifyDeliveryAddress(
                            testData.getJsonData("titleMale"),
                            testData.getJsonData("firstName"),
                            testData.getJsonData("lastName"),
                            testData.getJsonData("company"),
                            testData.getJsonData("address1"),
                            testData.getJsonData("address2"),
                            testData.getJsonData("zipcode"),
                            testData.getJsonData("city"),
                            testData.getJsonData("state"),
                            testData.getJsonData("country"),
                            testData.getJsonData("mobileNumber")   ).


                    verifyBillingAddress(
                            testData.getJsonData("titleMale"),
                            testData.getJsonData("firstName"),
                            testData.getJsonData("lastName"),
                            testData.getJsonData("company"),
                            testData.getJsonData("address1"),
                            testData.getJsonData("address2"),
                            testData.getJsonData("zipcode"),
                            testData.getJsonData("city"),
                            testData.getJsonData("state"),
                            testData.getJsonData("country"),
                            testData.getJsonData("mobileNumber"));



        }

@Test(dependsOnMethods = {"verifyProductDetails","CheckOut","ValidDateLoginTc","registerNewAccount"})
public void PaymentE2E() {
    new CheckOutPage(driver).clickOnPlaceOrder().fillCardInfo(
            testData.getJsonData("card.nameOnCard"),
            testData.getJsonData("card.cardNumber"),
            testData.getJsonData("card.cvc"),
            testData.getJsonData("card.expiryMonth"),
            testData.getJsonData("card.expiryYear"))
            .ClickpayButton()
            .verifyPaymentSuccessMessage(testData.getJsonData("messages.paymentSuccess"));


}
//@BeforeMethod(alwaysRun = true)
//{
//}
    @Test(groups = {"Invalid"})
    public void PaymentInvalidCard() {
        new CheckOutPage(driver).clickOnPlaceOrder().fillCardInfo(
                        testData.getJsonData("card.nameOnCard1"),
                        testData.getJsonData("card.cardNumber1"),
                        testData.getJsonData("card.cvc1"),
                        testData.getJsonData("card.expiryMonth1"),
                        testData.getJsonData("card.expiryYear1")).ClickpayButton()
                ;}










        @BeforeClass(alwaysRun = true)
        protected void setUp() {
            testData = new JsonReader("Payment-data");
            driver = new GUIDriver();
            new NavigationBarComponent(driver).navigate();
        }





        @AfterClass(alwaysRun = true)
        public void tearDown () {
            driver.quitDriver();
        }
    }

