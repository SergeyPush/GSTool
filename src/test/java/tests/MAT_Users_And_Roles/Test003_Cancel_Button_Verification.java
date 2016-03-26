package tests.MAT_Users_And_Roles;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.RandomName;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test003_Cancel_Button_Verification extends GSTAbstractClass {

    @Features("User management")
    @Test
    @Title("Test cancel button verification")
    public void testCancelButtonVerification() {

        OpenView.openExtras(UserAdministration);
        String name = RandomName.readFromFile().get(0);
        String password = "Some_password";

        //Select User
        $(By.partialLinkText(name)).click();

        //Click edit button
        $(By.xpath(".//*[@id='userAdministrationForm:changePassword']")).click();
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(present, 8000);

        //Enter new password
        $(By.xpath(".//*[@id='userAdministrationForm:newPassword']")).val(password);
        $(By.xpath(".//*[@id='userAdministrationForm:repeatPassword']")).val(password);

        //Click Cancel button
        $("#discardEnabled").click();

        //Asserts
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).shouldNot(appear);


    }
}
