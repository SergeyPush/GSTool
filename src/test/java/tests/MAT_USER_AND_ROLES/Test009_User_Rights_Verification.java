package tests.MAT_USER_AND_ROLES;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.RandomName;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test009_User_Rights_Verification extends GSTAbstractClass{


    @Features("User management")
    @Test
    @Title("Add permission to the role, verify that permissions work")
    public void testUserRightsVerification() {

        OpenView.openExtras(UserAdministration);

        //Select created user
        String username  = RandomName.readFromFile().get(0);
        String password  = RandomName.readFromFile().get(1);
        String rolename = "testrole";

        //Click Roles button
        $("#rolesEnabled").waitUntil(enabled, 8000).click();

        //Link the created role to the user
        String role = "//*[contains(text(), '" + rolename + "')]/../../../..//input";
        $(By.xpath(role)).waitUntil(present, 8000).setSelected(true);

        //Deselect Adminrolle
        String Adminrolle = "//*[contains(text(), 'Adminrolle')]/../../../..//input";
        $(By.xpath(Adminrolle)).setSelected(false);

        //Click Save button
        $(By.xpath(".//*[@id='role_panel_mpBForm:save_link']")).waitUntil(enabled, 8000).click();
        $("#role_panelHeader").waitUntil(disappear, 10000);


        //Asserts
        $$(By.xpath(".//*[@id='RoleDataList:j_id686']//*[@class='toggle_item_label']")).shouldHave(size(1)).shouldHave(texts(rolename));



//        TODO Make logout and login of newly created user and role
//        TODO Create new TO



    }
}
