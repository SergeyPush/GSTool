package com.infopulse.gst.autotest.MAT_Users_And_Roles;

import com.infopulse.gst.autotest.utils.Login;
import com.infopulse.gst.autotest.utils.SelectConcept;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenView;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Test012_Delete_Created_Role extends GSTAbstractClass{

    @Test
    @Title("Delete created role")
    public void testDeleteCreatedRole() throws Exception {
        Login.LoginProperly();
        SelectConcept.selectDefaultConcept();

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
