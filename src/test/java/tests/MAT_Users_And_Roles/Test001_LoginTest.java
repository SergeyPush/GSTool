package tests.MAT_Users_And_Roles;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import utils.Property_Loader;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Test001_LoginTest {

    @BeforeClass
    public static void setUpStat() throws Exception {
        String URL = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
        Configuration.browser = Property_Loader.loadProperty("browser.name");
        open(URL);
    }

    @Test
    @Title("Try to login without password")
    public void failedLogin1() throws Exception {

        $("#j_username").val("wronglogin").pressEnter();
        $("#loginMessage").shouldHave(text("Benutzername unbekannt oder Kennwort ungültig"));
        refresh();

    }

    @Test
    @Title("Try to login with wrong credentials")
    public void failedLogin2() throws Exception {

        refresh();
        $("#j_username").val("wronglogin");
        $("#j_password").val("wrongpass").pressEnter();


        $("#loginMessage").shouldHave(text("Benutzername unbekannt oder Kennwort ungültig"));


    }
}
