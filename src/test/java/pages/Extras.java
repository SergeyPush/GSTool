package pages;

import pages.Extras_pages.Role_administration;
import pages.Extras_pages.User_Administration;
import utils.BaseClass;
import utils.Property_Loader;

public class Extras extends BaseClass {

    public static User_Administration USER_ADMINISTRATION(){


        driver.navigate().to(Property_Loader.loadProperty("site.url") +"/userAdministration.jsf#");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User_Administration(driver);

    }


    public static Role_administration ROLE_ADMINISTRATION(){


        driver.navigate().to(Property_Loader.loadProperty("site.url") +"/userRolesAdministration.jsf");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Role_administration(driver);
    }

}
