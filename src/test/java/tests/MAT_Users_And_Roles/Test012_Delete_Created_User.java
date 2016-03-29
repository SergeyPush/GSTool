package tests.MAT_Users_And_Roles;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.RandomName;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Test012_Delete_Created_User extends GSTAbstractClass{

    @Title("Delete existing user")
    @Test()
    public void testDeleteCreatedUser() throws Exception {

        OpenView.openExtras(UserAdministration);

        String username = RandomName.readFromFile().get(0);

        //Selected user
        $(By.partialLinkText(username)).click();

        //Click Delete button
        $("#deleteElementEnabled").waitUntil(enabled, 8000).click();

        //Confirm deletion
        $("#confirmationDialog-confirm").click();

        //Asserts
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 8000).shouldHave(text("Item successfully deleted")).shouldHave(text(username));
    }
}
