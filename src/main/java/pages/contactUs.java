package pages;

import drivers.GUIDriver;
import pages.components.NavigationBarComponent;

public class contactUs {
    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;
    public contactUs(GUIDriver driver) {

        this.driver=driver;
        this.navigationBarComponent = new NavigationBarComponent(driver);
    }
}
