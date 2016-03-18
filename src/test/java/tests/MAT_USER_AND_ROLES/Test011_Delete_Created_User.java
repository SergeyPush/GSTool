package tests.MAT_USER_AND_ROLES;


import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.RandomName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test011_Delete_Created_User extends GSTAbstractClass{

    @Test
    @Features("User management")
    @Title("Delete existing user")
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
