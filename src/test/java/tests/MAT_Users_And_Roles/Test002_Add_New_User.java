package tests.MAT_Users_And_Roles;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.RandomName;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test002_Add_New_User extends GSTAbstractClass {

    @Features("User management")
    @Test
    @Title("Test create new user")
    public void testAddNewUser() {

        OpenView.openExtras(UserAdministration);

        String username = RandomName.getRandomName();
        String password = RandomName.getRandomPassword();

        //Add new User
        $("#addElementEnabled").waitUntil(enabled, 6000).click();
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(visible, 10000);

        //Enter name
        $(By.xpath(".//*[@id='userAdministrationForm:account']")).val(username);

        //Uncheck 'Password must be changed'
        $(By.xpath(".//*[@id='userAdministrationForm:isChangePassword']")).setSelected(false);

        //Enter and repeat password
        $(By.xpath(".//*[@id='userAdministrationForm:newPassword']")).val(password);
        $(By.xpath(".//*[@id='userAdministrationForm:repeatPassword']")).val(password);

        //Click save button
        $("#saveEnabled").click();

        //Asserts
        $(By.partialLinkText(username)).shouldBe(visible);
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 10000).shouldHave(text("Successfully saved")).shouldHave(text(username));

    }
}
