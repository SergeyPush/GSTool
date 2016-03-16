package tests.MAT_USER_AND_ROLES;


import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenPluses;
import utils.OpenView;
import utils.RandomName;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test004_Convert_User_To_Employee extends GSTAbstractClass {

    @Features("User management")
    @Test
    @Title("Convert Existing user to employee")
    public void testConvertUserToEmployee() throws Exception {

        OpenView.openExtras(UserAdministration);
        String username = RandomName.readFromFile().get(0);

        //Selected user
        $(By.partialLinkText(username)).click();

        //Click 'Convert selected user into Employee'
        $("#convertEnabled").click();

        //Verify confirmation is displayed
        $(By.xpath(".//*[@id='notificationDialogContentTable']/tbody/tr[2]/td/span")).waitUntil(present, 8000)
                .shouldHave(text("The Target object of type Employee has been created successfully"));

        $(By.xpath(".//*[@id='notificationDialog-confirm']")).click();
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).shouldBe(present)
                .shouldHave(text("Successfully saved")).shouldHave(text(username));


        OpenView.NavigateTO(Grundschutz, InventoryAnalysis);
        OpenPluses.ExpandAll();

        $(By.partialLinkText(username)).shouldBe(present, enabled);

    }
}
