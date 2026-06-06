package pages;

import drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.components.NavigationBarComponent;
import utils.dataReader.PropertyReader;
import utils.logs.LogsManager;

public class ProductDetailsPage {
    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;


    public ProductDetailsPage(GUIDriver driver) {
        this.driver = driver;
        this.navigationBarComponent = new NavigationBarComponent(driver);

    }

    private final  String productDetailsEndpoint = "/product-details/12";

    private final By productName = By.cssSelector(".product-information > h2");
    private final By productPrice = By.cssSelector(".product-information > span > span");
    private final By name = By.id("name");
    private final By email = By.id("email");
    private final By reviewTextArea = By.id("review");
    private final By reviewButton = By.id("button-review");
    private final By reviewMsg = By.cssSelector("#review-section span");


    public ProductDetailsPage navigate() {
        driver.browser().navigateTo(PropertyReader.getProperty("BASE_URL") + productDetailsEndpoint);
        return this;
    }




    @Step("write review on product")
    public ProductDetailsPage addReview(String name, String email, String review) {
        driver.element().type(this.name, name);
        driver.element().type(this.email, email);
        driver.element().type(this.reviewTextArea, review);
        driver.element().click(this.reviewButton);
        return this;
    }





    @Step("verify product details")
    public ProductDetailsPage verifyProductDetails(String pName, String pPrice) {
        String actualProductName = driver.element().getText(productName);
        String actualProductPrice = driver.element().getText(productPrice);
        LogsManager.info("actual product name:", actualProductName, "actual price:", actualProductPrice);
        driver.validation().Equals(actualProductName, pName, "Product Name Verification Failed")
        .Equals(actualProductPrice, pPrice, "Product Price Verification Failed");
        return this;
    }

    @Step("verify review message")
    public ProductDetailsPage verifyReviewMsg(String msg) {
        String actualMsg = driver.element().getText(reviewMsg);
        LogsManager.info("actual msg:", actualMsg);
        driver.verification().Equals(actualMsg, msg, "Review Message Verification Failed");
        return this;
    }
}