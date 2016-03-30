package com.infopulse.gst.autotest.MAT_Users_And_Roles;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenView;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Test007_Cancel_Button_Verification extends GSTAbstractClass{

    @Test
    @Title("Cancel button verification for role")
    public void testCancelButtonVerification() throws Exception {

        OpenView.openExtras(RoleAdministration);

        //Select created role
        $(By.partialLinkText("testrole")).click();

        //Add description to the role
        String description = "This is new description of the role";
        $(By.xpath(".//*[@id='roleAdministrationForm:description']")).val(description);

        //Wait until Changed is present
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(present, 8000);

        //Click Cancel button
        $("#discardEnabled").waitUntil(enabled, 8000).click();

        //Assert
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).shouldNot(appear);


    }
}
