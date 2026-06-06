package pages;

import drivers.GUIDriver;
import pages.components.NavigationBarComponent;

public class testCases {
    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;
    public testCases(GUIDriver driver) {
        this.driver = driver;
        this.navigationBarComponent = new NavigationBarComponent(driver);
    }
}
