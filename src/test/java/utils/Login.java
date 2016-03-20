package utils;

import static com.codeborne.selenide.Selenide.$;

public class Login {

    public static void LoginProperly() {
        String Username = Property_Loader.loadProperty("user.username");
        String Password = Property_Loader.loadProperty("user.password");

        $("#j_username").val(Username);
        $("#j_password").val(Password);
        $("#j_submit").click();
    }

    public static void LoginAs(String Username, String Password) {

        $("#j_username").val(Username);
        $("#j_password").val(Password);
        $("#j_submit").click();

    }
}
