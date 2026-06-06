package pages;

import drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.components.NavigationBarComponent;
import utils.dataReader.PropertyReader;

public class cartPage {

    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;

    public cartPage(GUIDriver driver) {

        this.driver = driver;
        this.navigationBarComponent = new NavigationBarComponent(driver);
    }

    private String cartPageEndPoint = "/view_cart";

    private final By proceedToCheckOut = By.cssSelector("a.btn.btn-default.check_out");


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


    private By removePro(String productName) {
        return By.xpath("(//h4  /a[.='" + productName + "'] //following::td[@class='cart_delete'] /a)[1]");
    }

@Step("Navigate---> Cart Page")
    public cartPage navigate() {
        driver.browser().navigateTo(PropertyReader.getProperty("BASE_URL") + cartPageEndPoint);
        return this;
    }

@Step("Click on Proceed to Check Out")
    public CheckOutPage clickProceedToCheckOut() {
        driver.element().click(proceedToCheckOut);
        return new CheckOutPage(driver);
    }

@Step("Remove Product from Cart")
    public cartPage removeProduct(String productNam) {
        driver.element().click(removePro(productNam));
        return this;
    }
@Step("Verify Product on Cart")
    public cartPage verifyProductDetaOnCart(String productName, String productPrice, String productQuantity, String productTotal) {
        String actualProductName = driver.element().getText(productName(productName));
        String actualProductPrice = driver.element().getText(productPrice(productName));
        String actualProductQuantity = driver.element().getText(productQuantity(productName));
        String actualProductTotal = driver.element().getText(productTotal(productName));

        driver.validation().Equals(actualProductName, productName, "Product name does not match")
                .Equals(actualProductPrice, productPrice, "Product price does not match")
                .Equals(actualProductQuantity, productQuantity, "Product quantity does not match")
                .Equals(actualProductTotal, productTotal, "Product total does not match");
        return this ;
    }


}




