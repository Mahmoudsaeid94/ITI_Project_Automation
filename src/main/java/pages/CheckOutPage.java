package pages;

import drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.dataReader.PropertyReader;

public class CheckOutPage {
    private final GUIDriver driver;
    private String checkoutEndpoint = "/checkout";

    public CheckOutPage(GUIDriver driver) {
        this.driver = driver;
    }


    private final By deliveryName = By.xpath("//ul[@id='address_delivery'] /li[@class='address_firstname address_lastname']");
    private final By deliveryCompany = By.xpath("//ul[@id='address_delivery'] /li[@class='address_address1 address_address2'][1]");
    private final By deliveryAddress1 = By.xpath("//ul[@id='address_delivery'] /li[@class='address_address1 address_address2'][2]");
    private final By deliveryAddress2 = By.xpath("//ul[@id='address_delivery'] /li[@class='address_address1 address_address2'][3]");
    private final By deliveryCityStateZip = By.xpath("//ul[@id='address_delivery'] /li[@class='address_city address_state_name address_postcode']");
    private final By deliveryCountry = By.xpath("//ul[@id='address_delivery'] /li[@class='address_country_name']");
    private final By deliveryPhone = By.xpath("//ul[@id='address_delivery'] /li[@class='address_phone']");
    private final By billingName = By.xpath("//ul[@id='address_invoice'] /li[@class='address_firstname address_lastname']");
    private final By billingCompany = By.xpath("//ul[@id='address_invoice'] /li[@class='address_address1 address_address2'][1]");
    private final By billingAddress1 = By.xpath("//ul[@id='address_invoice'] /li[@class='address_address1 address_address2'][2]");
    private final By billingAddress2 = By.xpath("//ul[@id='address_invoice'] /li[@class='address_address1 address_address2'][3]");
    private final By billingCityStateZip = By.xpath("//ul[@id='address_invoice'] /li[@class='address_city address_state_name address_postcode']");
    private final By billingCountry = By.xpath("//ul[@id='address_invoice'] /li[@class='address_country_name']");
    private final By billingPhone = By.xpath("//ul[@id='address_invoice'] /li[@class='address_phone']");

    private By productName(String productName) {
        return By.xpath("(//h4  /a[.='" + productName + "'])[1]");
    }


    private By productPrice(String productName) {
        return By.xpath("(//h4  /a[.='" + productName + "'] //following::td[@class='cart_price'] /p)[1]");
    }


    private By productQuantity(String productName) {
        return By.xpath("(//h4  /a[.='" + productName + "'] //following::td[@class='cart_quantity'] /button)[1]");
    }


    private By productTotal(String productName) {
        return By.xpath("(//h4  /a[.='" + productName + "'] //following::td[@class='cart_total'] /p)[1]");
    }

    private final By TotalAmount = By.cssSelector("div#cart_info > table:nth-of-type(1) > tbody:nth-of-type(1) > tr:nth-of-type(8) > td:nth-of-type(4) > p:nth-of-type(1)");
    private final By placeOrderButton = By.cssSelector("a.btn.btn-default.check_out");
    private final By CommentYOrder = By.name("message");


    @Step("Navigate To Checkout Page")
    public CheckOutPage navigate() {
        driver.browser().navigateTo(PropertyReader.getProperty("BASE_URL") + checkoutEndpoint);
        return this;
    }

    @Step("Click On Place Order Button")
    public PaymentPage clickOnPlaceOrder() {
        driver.element().click(placeOrderButton);
        return new PaymentPage(driver);
    }

    @Step("Verify Delivery Address")
    public CheckOutPage verifyDeliveryAddress(String title, String fName, String lName, String company, String address1, String address2,
                                              String city, String state, String zip, String country, String phone) {
        driver.validation().Equals(driver.element().getText(deliveryName), (title + ". " + fName + " " + lName), " Delivery Name is not matched")
                .Equals(driver.element().getText(deliveryCompany), company, " Delivery Company is not matched")
                .Equals(driver.element().getText(deliveryAddress1), address1, " Delivery Address1 is not matched")
                .Equals(driver.element().getText(deliveryAddress2), address2, " Delivery Address2 is not matched")
                .Equals(driver.element().getText(deliveryCityStateZip), (state+ " " + zip + " " + city), " Delivery CityStateZip is not matched")
                .Equals(driver.element().getText(deliveryCountry), country, " Delivery Country is not matched")
                .Equals(driver.element().getText(deliveryPhone), phone, " Delivery Phone is not matched");
        return this;
    }


    @Step("Verify Billing Address")
    public CheckOutPage verifyBillingAddress(String title, String fName, String lName, String company, String address1, String address2,
                                             String city, String state, String zip, String country, String phone) {
        driver.validation().Equals(driver.element().getText(billingName), (title + ". " + fName + " " + lName), " Billing Name is not matched")
                .Equals(driver.element().getText(billingCompany), company, " Billing Company is not matched")
                .Equals(driver.element().getText(billingAddress1), address1, " Billing Address1 is not matched")
                .Equals(driver.element().getText(billingAddress2), address2, " Billing Address2 is not matched")
                .Equals(driver.element().getText(billingCityStateZip), (state+ " " + zip + " " + city), " Billing CityStateZip is not matched")
                .Equals(driver.element().getText(billingCountry), country, " Billing Country is not matched")
                .Equals(driver.element().getText(billingPhone), phone, " Billing Phone is not matched");
        return this;
    }

    @Step("Verify Your Order")
    public CheckOutPage verifyYourOrder(String productName, String productPrice, String productQuantity, String productTotal) {
        String actualProductName = driver.element().getText(productName(productName));
        String actualProductPrice = driver.element().getText(productPrice(productName));
        String actualProductQuantity = driver.element().getText(productQuantity(productName));
        String actualProductTotal = driver.element().getText(productTotal(productName));

        driver.validation().Equals(actualProductName, productName, "Product name does not match")
                .Equals(actualProductPrice, productPrice, "Product price does not match")
                .Equals(actualProductQuantity, productQuantity, "Product quantity does not match")
                .Equals(actualProductTotal, productTotal, "Product total does not match");
        return this;

    }

    @Step("Verify TotalAmount Of Order")
    public CheckOutPage verifyTotalAmountOfOrder(String totalAmount) {
        String actualTotalAmount = driver.element().getText(TotalAmount);
        driver.validation().Equals(actualTotalAmount, totalAmount, "Total Amount does not match");
        return this;
    }

    @Step("Enter Comment For Order")
    public CheckOutPage enterCommentForOrder(String comment) {
        driver.element().type(CommentYOrder, comment);
        return this;
    }


}

