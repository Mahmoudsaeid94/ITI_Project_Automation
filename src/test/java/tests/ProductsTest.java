
package tests;

import drivers.GUIDriver;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.components.NavigationBarComponent;
import pages.productsPage;
import utils.TimeManager;
import utils.dataReader.JsonReader;

@Epic("Automation Exercise")
@Story("User Products Test cases")
@Severity(SeverityLevel.NORMAL)
@Owner("Mahmoud Saeid ITI")
public class ProductsTest extends BaseTest {
    String timestamp = TimeManager.getTimestampP();

    @Test
    @Description("Search for a product")
    public void searchForProductTest() {
        new productsPage(driver).navigate().
                searchProduct(testData.getJsonData("searchProduct.name")).
                validateProductDetails(
                        testData.getJsonData("searchProduct.name"),
                        testData.getJsonData("searchProduct.price"));


    }

    @Test
    @Description("Search for a product CategoryMan")
    public void searchForProductCategoryTest() {
        new productsPage(driver).navigate().
                searchProductCategory(testData.getJsonData("searchProductCategory.Men"));}
    @Test(groups = {"Invalid"})
    @Description("Search for a product Invalid data")
    public void searchForProductCategoryTestInvalid() {
        new productsPage(driver).navigate().
                searchProductCategory(testData.getJsonData("searchWithInvalidData.Space"));}
    @Test
    @Description("Add product to cart Without Login")

    public void addProductToCartTestWithoutLogin() {
        new productsPage(driver).navigate().clickOnAddToCart(testData.getJsonData("products4.name"))
                .validateItemAddedLabel(testData.getJsonData("messages.cartAdded"));

    }

    @Test
    @Description("Add '2' product to cart Without Login")

    public void addProductToCartTest() {
        new productsPage(driver).navigate().clickOnAddToCart(testData.getJsonData("products4.name"))
                        .validateItemAddedLabel(testData.getJsonData("messages.cartAdded")).clickOnContinueShopping().clickOnAddToCart(testData.getJsonData("products3.name"))
                .validateItemAddedLabel(testData.getJsonData("messages.cartAdded")).clickOnViewCart();

    }



@BeforeClass(alwaysRun = true)
protected void preCondition() {
    testData = new JsonReader("products-data");
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
