package pages;

import pages.Common_pages.MainMenu;
import pages.Common_pages.TopMenu;
import utils.BaseClass;



public class Common extends BaseClass {


    public static MainMenu MAIN_MENU(){

        return new MainMenu(driver);
    }

    public static TopMenu TOP_MENU(){
        return new TopMenu(driver);
    }
}
