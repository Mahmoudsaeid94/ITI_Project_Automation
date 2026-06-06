package tests;

import drivers.GUIDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.components.NavigationBarComponent;
import pages.productsPage;
import utils.dataReader.JsonReader;

public class ProductDetailsTest extends BaseTest {

@Test
public void verifyProductDetails() {
new productsPage(driver).navigate().
        clickOnViewProduct(testData.getJsonData("product.name")).
        verifyProductDetails(testData.getJsonData("product.name"), testData.getJsonData("product.price"));


}


    @Test
    public void verifyReviewMassage() {


        new productsPage(driver).navigate().
                clickOnViewProduct(testData.getJsonData("product.name")).
                addReview(testData.getJsonData("review.name"),testData.getJsonData("review.email"),
                        testData.getJsonData("review.review")).verifyReviewMsg(testData.getJsonData("message.review"));
        }


    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("productDetails-data");
    }

    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
        new NavigationBarComponent(driver).navigate();

    }

    @AfterMethod
    public void tearDown() {
        driver.quitDriver();
    }

}
