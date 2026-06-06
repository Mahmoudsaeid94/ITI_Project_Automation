package pages;

import drivers.GUIDriver;
import pages.components.NavigationBarComponent;

public class apiTesting {
    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;
    public apiTesting(GUIDriver driver) {
        this.driver=driver;
        this.navigationBarComponent = new NavigationBarComponent(driver);
    }
}
