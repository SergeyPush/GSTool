package pages;

import pages.Common_pages.MainMenu;
import utils.BaseClass;



public class Common extends BaseClass {


    public static MainMenu MAIN_MENU(){

        return new MainMenu(driver);
    }
}
