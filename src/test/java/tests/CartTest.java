package tests;

import drivers.GUIDriver;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.components.NavigationBarComponent;
import pages.productsPage;
import utils.dataReader.JsonReader;

@Epic("Automation Exercise")
@Story("User Cart Test cases")
@Severity(SeverityLevel.NORMAL)
@Owner("Mahmoud Saeid ITI")
public class CartTest extends BaseTest {

@Test
public void verifyProductOnCart() {
    new productsPage(driver).navigate().
        clickOnAddToCart(testData.getJsonData("products3.name")).
  validateItemAddedLabel(testData.getJsonData("messages.cartAdded")).clickOnViewCart().
            verifyProductDetaOnCart(testData.getJsonData("products3.name"), (testData.getJsonData("products3.price")),
                    testData.getJsonData("products3.quantity"), testData.getJsonData("products3.total"));}


    @Test
    public void verifyRemoveProductOnCart() {
        new productsPage(driver).navigate().
                clickOnAddToCart(testData.getJsonData("products3.name")).
                validateItemAddedLabel(testData.getJsonData("messages.cartAdded")).clickOnViewCart().removeProduct(testData.getJsonData("products3.name"));

}

    @BeforeClass
    protected void preCondition () {
        testData = new JsonReader("Cart-data");
    }

    @BeforeMethod
    public void setUp () {
        driver = new GUIDriver();
        new NavigationBarComponent(driver).navigate();

    }

    @AfterMethod
    public void tearDown () {
        driver.quitDriver();
    }

}
