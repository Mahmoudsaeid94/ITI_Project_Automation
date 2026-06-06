package pages;

import drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.components.NavigationBarComponent;
import utils.logs.LogsManager;
import utils.dataReader.PropertyReader;
public class productsPage {
    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;

    public productsPage(GUIDriver driver) {
        this.driver=driver;
        this.navigationBarComponent = new NavigationBarComponent(driver);


    }

private String productsPageEndPoint = "/products";

 private final By searchField = By.id("search_product");
 private final By searchButton = By.id("submit_search");
 private final By AllProductsLabel =By.cssSelector("h2.title.text-center");
 private final By itemAddedLabel = By.cssSelector(" h4.modal-title.w-100");

 private final By viewCartButton = By.cssSelector("p > [href=\"/view_cart\"]");
 private final By continueShoppingButton = By.cssSelector("button.btn.btn-success.close-modal.btn-block");



    //dynamic locators
  /*    private By productName(String productName) {
        return By.xpath("//div[@class='overlay-content'] /p[.='" + productName + "']");
   }*/
    private By productName(String productName){
        return By.xpath("//p[normalize-space()='" + productName + "']");
    }

    private By productPrice(String productName) {
        return By.xpath("//div[@class='overlay-content'] /p[.='" + productName + "'] //preceding-sibling::h2");
    }

    private By hoverOnProduct(String productName) {
        return By.xpath("//div[@class='productinfo text-center'] /p[.='" + productName + "']");
    }

    private By addToCartButton(String productName) {
        return By.xpath("//div[@class='productinfo text-center'] /p[.='" + productName + "'] //following-sibling::a");
    }

    private By viewProduct(String productName) {
        return By.xpath("//p[.='" + productName + "'] //following::div[@class='choose'][1]");
    }

    @Step("Navigate---> Products Page")
    public productsPage navigate() {

        driver.browser().navigateTo(PropertyReader.getProperty("BASE_URL") + productsPageEndPoint);
        return this;

    }

    @Step("Search for product BY {productName}")
    public productsPage searchProduct(String productName) {
        driver.element().type(searchField, productName)
                .click(searchButton);
        return this;
    }

    @Step("Search for product BY {searchProductCategory}")
    public productsPage searchProductCategory(String searchProductCategory) {
        driver.element().type(searchField,searchProductCategory)
                .click(searchButton);
        return this;
    }
    @Step("Click on Add to Cart for product: {productName}")
    public productsPage clickOnAddToCart(String productName) {
        driver.element().hover(hoverOnProduct(productName))
                .click(addToCartButton(productName));
        return this;
    }
//----> nav to PDetailsPage
    @Step("Click on View Product for product: {productName}")
    public ProductDetailsPage clickOnViewProduct(String productName) {
        driver.element().click(viewProduct(productName));
        return new ProductDetailsPage(driver);
    }

    @Step("Click on View Cart")
    public cartPage  clickOnViewCart() {
        driver.element().click(viewCartButton);
        return new cartPage(driver);
    }

    @Step("Click on Continue Shopping")
    public productsPage clickOnContinueShopping() {
        driver.element().click(continueShoppingButton);
        return this;
    }

    //validations
    @Step("Validate product details for {pName} with price {pPrice}")
    public productsPage validateProductDetails(String productName, String productPrice) {
        String actualProductName = driver.element().hover(productName(productName)).getText(productName(productName));
        String actualProductPrice = driver.element().hover(productName(productName)).getText(this.productPrice(productName));
        LogsManager.info("Validating product details for: " + actualProductName, " with price: " + actualProductPrice);
        driver.validation().Equals(actualProductName, productName, "Product name does not match");
        driver.validation().Equals(actualProductPrice, productPrice, "Product price does not match");
        return this;
    }

    @Step("Validate item added label contains: {expectedText}")
    public productsPage validateItemAddedLabel(String expectedText) {
        String actualTxt = driver.element().getText(itemAddedLabel);
        LogsManager.info("Validating item added label: " + actualTxt);
        driver.verification().Equals(actualTxt, expectedText, "Item added label does not match expected text");
        return this;
    }




}

