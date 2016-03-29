package tests.MAT_Users_And_Roles;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import utils.*;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class Test010_LoginTest extends GSTAbstractClass{

    private String Username = RandomName.readFromFile().get(0);

    @Test
    @Title("Try to login without password")
    public void failedLogin1() throws Exception {

        $("#j_username").val(Username).pressEnter();
        $("#loginMessage").shouldHave(text("Benutzername unbekannt oder Kennwort ungültig"));


    }

    @Test
    @Title("Try to login with wrong credentials")
    public void failedLogin2() throws Exception {

        refresh();
        $("#j_username").val(Username);
        $("#j_password").val("wrongpass").pressEnter();


        $("#loginMessage").shouldHave(text("Benutzername unbekannt oder Kennwort ungültig"));


    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        refresh();
        Login.LoginProperly();
        SelectConcept.selectDefaultConcept();
    }
}
