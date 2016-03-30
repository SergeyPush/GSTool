package com.infopulse.gst.autotest.MAT_Users_And_Roles;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenView;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Test008_Changing_Role_Permissions extends GSTAbstractClass{

    @Test
    @Title("Changing permissions for the role")

    public void testChangingPermissionsForTheRole() throws InterruptedException {

        OpenView.openExtras(RoleAdministration);

        String role = "testrole";

        //Select created role
        $(By.partialLinkText(role)).click();

        //Click Global
        $(By.partialLinkText("Global")).waitUntil(enabled, 8000).click();

        //Open modules tab
        $(By.xpath(".//*[@id='roleAdministrationForm:tabModules_lbl']")).waitUntil(enabled, 8000).click();

        //Enable all permissions
        Thread.sleep(1000);
        $(By.xpath(".//*[@id='1']/table/tbody/tr/td[6]/div/input")).waitUntil(enabled, 8000).setSelected(true);
        $(By.xpath(".//*[@id='1']/table/tbody/tr/td[7]/div/input")).waitUntil(enabled, 8000).setSelected(true);
        $(By.xpath(".//*[@id='1']/table/tbody/tr/td[8]/div/input")).waitUntil(enabled, 8000).setSelected(true);
        $(By.xpath(".//*[@id='1']/table/tbody/tr/td[9]/div/input")).waitUntil(enabled, 8000).setSelected(true);
        $(By.xpath(".//*[@id='1']/table/tbody/tr/td[10]/div/input")).waitUntil(enabled, 8000).setSelected(true);
        $(By.xpath(".//*[@id='1']/table/tbody/tr/td[11]/div/input")).waitUntil(enabled, 8000).setSelected(true);

        //Click Save button
        $("#saveEnabled").waitUntil(enabled, 8000).click();


        //Asserts
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 8000).shouldHave(text(role)).shouldHave(text("Successfully saved"));


    }
}
