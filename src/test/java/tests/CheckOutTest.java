package tests;

import drivers.GUIDriver;
import org.testng.annotations.*;
import pages.SignupLoginPage;
import pages.SignupPage;
import pages.components.NavigationBarComponent;
import pages.productsPage;
import pages.cartPage;
import utils.TimeManager;
import utils.dataReader.JsonReader;

public class CheckOutTest extends BaseTest{
    String timestamp = TimeManager.getTimestampP();









@Test
    public void registerNewAccount(){
    new SignupLoginPage(driver).navigate().
            enterSignUpName(testData.getJsonData("name")).

            enterSignUpEmail(testData.getJsonData("email") + timestamp + "@adil.com").
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
                enterLoginEmail(testData.getJsonData("email") + timestamp + "@adil.com").
                enterLoginPassword(testData.getJsonData("password")).
                clickLoginButton().
                verifyLoginPageLabel();
    }






    @Test(dependsOnMethods = {"ValidDateLoginTc","registerNewAccount"})
        public void addProductToCartTest() {
            new productsPage(driver).navigate().clickOnAddToCart(testData.getJsonData("products4.name"))
                    .validateItemAddedLabel(testData.getJsonData("messages.cartAdded")).
                    clickOnViewCart().
                    verifyProductDetaOnCart(testData.getJsonData("products4.name"),
                                            testData.getJsonData("products4.price"),
                                            testData.getJsonData("products4.quantity"),
                                            testData.getJsonData("products4.total"));

        }




    @Test(dependsOnMethods ={"addProductToCartTest","ValidDateLoginTc","registerNewAccount"} )
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



    @BeforeClass
    protected void setUp() {
        testData = new JsonReader("CheckOut-data");
        driver = new GUIDriver();
        new NavigationBarComponent(driver).navigate();
    }





    @AfterClass
    public void tearDown () {
        driver.quitDriver();
    }
}
