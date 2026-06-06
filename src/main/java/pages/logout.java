package pages;

import drivers.GUIDriver;
import org.apache.commons.math3.special.Gamma;
import pages.components.NavigationBarComponent;

public class logout {
    private final GUIDriver driver;
    public NavigationBarComponent navigationBarComponent;
        public logout(GUIDriver driver) {
            this.driver=driver;
            this.navigationBarComponent = new NavigationBarComponent(driver);
        }
}
