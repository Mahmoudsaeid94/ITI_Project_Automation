package tests;

import drivers.GUIDriver;
import drivers.UITest;
import drivers.WebDriverProvider;
import utils.dataReader.JsonReader;
import org.openqa.selenium.WebDriver;
@UITest
    public class BaseTest implements WebDriverProvider {
        protected GUIDriver driver;
        protected JsonReader testData;


        @Override
        public WebDriver getWebDriver() {
            return driver.get();
        }
    }

