package utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Login {

    public static void LoginProperly() {
        if ($("#j_username").isDisplayed()) {

            String Username = Property_Loader.loadProperty("user.username");
            String Password = Property_Loader.loadProperty("user.password");

            $("#j_username").val(Username);
            $("#j_password").val(Password);
            $("#j_submit").click();
            $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).waitUntil(visible, 10000);
        }
    }

    public static void LoginAs(String Username, String Password) {

        $("#j_username").val(Username);
        $("#j_password").val(Password);
        $("#j_submit").click();

    }
}
