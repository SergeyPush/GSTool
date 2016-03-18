package tests.MAT_USER_AND_ROLES;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.Property_Loader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test001_LoginTest {

    @BeforeClass
    public static void setUpStat() throws Exception {
        String URL = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
        Configuration.browser = Property_Loader.loadProperty("browser.name");
        open(URL);
    }

    @Features("User management")
    @Test
    @Title("Try to login without password")
    public void failedLogin1() throws Exception {

        $("#j_username").val("wronglogin").pressEnter();
        $("#loginMessage").waitUntil(present, 8000).shouldHave(text("Benutzername unbekannt oder Kennwort ungültig"));

    }

    @Features("User management")
    @Test
    @Title("Try to login with wrong credentials")
    public void failedLogin2() throws Exception {

        $("#j_username").val("wronglogin");
        $("#j_password").val("wrongpass").pressEnter();


        $("#loginMessage").waitUntil(present, 8000).shouldHave(text("Benutzername unbekannt oder Kennwort ungültig"));

    }
}
