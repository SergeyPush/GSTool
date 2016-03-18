package tests.MAT_USER_AND_ROLES;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test010_Delete_Created_Role extends GSTAbstractClass{

    @Features("User management")
    @Test
    @Title("Delete created role")
    public void testDeleteCreatedRole() throws Exception {

        OpenView.openExtras(RoleAdministration);

        String rolename = "testrole";

        //Select role
        $(By.partialLinkText(rolename)).click();

        //Click delete button
        $("#deleteElementEnabled").waitUntil(enabled, 8000).click();

        //Confirm remove
        $("#confirmationDialog-confirm").waitUntil(present, 8000).click();

        //Asserts
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 8000).shouldHave(text("Item successfully deleted")).shouldHave(text(rolename));

    }
}
