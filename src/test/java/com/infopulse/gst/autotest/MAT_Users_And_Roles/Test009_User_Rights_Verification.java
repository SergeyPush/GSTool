package com.infopulse.gst.autotest.MAT_Users_And_Roles;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.infopulse.gst.autotest.utils.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Test009_User_Rights_Verification extends GSTAbstractClass {

    //Select created user

    private String rolename = "testrole";
    private String TOname = "tempBuilding";


    @Test
    @Title("Add permission to the role, verify that permissions work")
    public void test001UserRightsVerification() throws InterruptedException {

        OpenView.openExtras(UserAdministration);

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
        $$(By.xpath(".//*[@id='RoleDataList:j_id686']//*[@class='toggle_item_label']")).shouldHave(sizeGreaterThanOrEqual(1)).shouldHave(texts(rolename));

        //Logout
        $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).waitUntil(enabled, 6000).click();

    }


    @Test
    @Title("Change language verify access to Base oprions Configuration options permission")
    public void test002ChangeLanguage() throws Exception {

        String username = RandomName.readFromFile().get(0);
        String password = RandomName.readFromFile().get(1);

        //Login with new credentials and select concept
        Login.LoginAs(username, password);
        $(By.xpath(".//*[@id='changeSafetyConceptForm:safetyConceptGroupMenu']")).waitUntil(present, 8000).selectOption(1);
        $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).waitUntil(enabled, 6000).click();

        //Open Base settings in German Grundfunktionen and select English Language
        OpenView.openExtras("Einstellungen");
        $(By.xpath(".//*[@id='1']/table/tbody/tr/td[4]/a")).click();
        $(By.xpath(".//*[@id='baseOptionsForm:j_id608:0:j_id610_body']/table/tbody/tr/td[2]/select")).selectOption("Englisch");
        $("#saveEnabled").waitUntil(enabled, 10000).click();
        $(By.xpath(".//*[@id='footerForm:message']/dt")).waitUntil(visible, 8000);
        Thread.sleep(1000);
    }

    @Test
    @Title("Create new building to verify R,E,C permissions")
    public void test003CreateNewBuilding() throws Exception {

        OpenView.NavigateTO(Grundschutz, InventoryAnalysis);
        //Create TO

        TargetObject.CreateNew("Building", TOname, null);

        //Assert
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 10000).shouldHave(text("Successfully saved")).shouldHave(text(TOname));
        $(By.partialLinkText(TOname)).waitUntil(present, 8000).shouldBe(visible, enabled);
    }


    @Test
    @Title("Delete created TO, check L permission")
    public void test004DeleteCreatedBuilding() throws Exception {
        // Select created TO

        $(By.partialLinkText(TOname)).click();

        // Click Delete button and confirm deletion
        $("#deleteElementEnabled").waitUntil(enabled, 6000).click();
        $("#genericConfirmPanelYes").waitUntil(enabled, 8000).click();

        $("#genericConfirmPanelYes").waitUntil(disappear, 8000);

        // Assertion
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 8000)
                .shouldHave(text("Item successfully deleted")).shouldHave(text(TOname));

    }

    @AfterClass
    public void tearDownClass() throws Exception {
        //Logout from application
        if($(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).exists()){
            $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).waitUntil(enabled,10000).click();
        }

    }
}
