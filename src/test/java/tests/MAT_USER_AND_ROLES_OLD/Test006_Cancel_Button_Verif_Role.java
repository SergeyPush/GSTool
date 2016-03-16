package tests.MAT_USER_AND_ROLES_OLD;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Extras;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;

public class Test006_Cancel_Button_Verif_Role extends BaseClass {

    @Features("User management")
    @Test
    @Title("Cancel button verification for role")
    public void testName() throws Exception {
        LoginUser.LoginProperly();

        Extras.ROLE_ADMINISTRATION().EditDescription("This is new description");

        Assert.assertFalse(driver.findElement(By.xpath(".//*[@id='footerForm:message']")).isDisplayed());



    }
}
