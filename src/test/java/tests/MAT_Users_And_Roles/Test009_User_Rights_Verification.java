package tests.MAT_Users_And_Roles;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import utils.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Test009_User_Rights_Verification extends GSTAbstractClass {


    @Test
    @Title("Add permission to the role, verify that permissions work")
    public void testUserRightsVerification() throws InterruptedException {

        OpenView.openExtras(UserAdministration);

        //Select created user
        String username = RandomName.readFromFile().get(0);
        String password = RandomName.readFromFile().get(1);
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


        //Logout
        $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).waitUntil(enabled, 6000).click();


        //Login with new credentials and select concept
        Login.LoginAs(username, password);
        $(By.xpath(".//*[@id='changeSafetyConceptForm:safetyConceptGroupMenu']")).selectOption(1);
        $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).waitUntil(enabled, 6000).click();


        //Create TO
        String TOname = "tempBuilding";
        TargetObject.CreateNew("Gebäude", TOname, null);

        //Assert
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 10000).shouldHave(text("Speichern erfolgreich abgeschlossen")).shouldHave(text(TOname));
        $(By.partialLinkText(TOname)).waitUntil(present, 8000).shouldBe(visible, enabled);


    }

    @Test(dependsOnMethods = "testUserRightsVerification")
    @Title("Add permission to the role, verify that permissions work")
    public void testUserRightsVerificationRelogin() throws InterruptedException {

        //Logout amd login
        $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).click();
        Login.LoginProperly();
        $("#closeChangeSafetyConcept").waitUntil(enabled, 10000).click();
    }

}
