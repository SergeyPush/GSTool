package tests.MAT_USER_AND_ROLES;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.RandomName;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test005_Linking_Roles extends GSTAbstractClass{

    @Features("User management")
    @Test
    @Title("Add more roles to existing user")
    public void testLinkingRoles() throws Exception {
        OpenView.openExtras(UserAdministration);

        String Username = RandomName.readFromFile().get(0);

        //Select user
        $(By.partialLinkText(Username)).click();

        //Click on roles
        $("#rolesEnabled").click();

        //Select Adminrolle
        $(By.xpath(".//*[@id='role_panel_mpBForm:role_panel_dataTable:0:role_panel_richColumn0']/div/input")).click();
        $(By.xpath(".//*[@id='role_panel_mpBForm:save_link']")).waitUntil(enabled, 7000).click();

        //Asserts
        $$(By.xpath(".//*[@id='RoleDataList:j_id686']//*[@class='toggle_item_label']")).shouldHave(size(1)).shouldHave(texts("Adminrolle"));




    }
}
