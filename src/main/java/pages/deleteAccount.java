package pages;

import drivers.GUIDriver;
import pages.components.NavigationBarComponent;

public class deleteAccount {
    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;
    public deleteAccount(GUIDriver driver) {
        this.driver=driver;
        this.navigationBarComponent = new NavigationBarComponent(driver);
    }
}
