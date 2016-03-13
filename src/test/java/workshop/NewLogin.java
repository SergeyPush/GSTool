package workshop;

import static com.codeborne.selenide.Selenide.$;

public class NewLogin extends NewAbstract{

    public static void loginAs(String name, String password){

        $("#j_username").val(name);
        $("#j_password").val(password);
        $("#j_submit").click();
    }
}
