package tests.SecurityConceptCreation.utils;

import utils.Property_Loader;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static void LoginProperly(){
        String Username = Property_Loader.loadProperty("user.username");
        String Password = Property_Loader.loadProperty("user.password");


        $("#j_username").sendKeys(Username);
        $("#j_password").sendKeys(Password);
        $("#j_submit").click();
    }
}
