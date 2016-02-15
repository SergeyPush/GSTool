package tests.MAT_USER_AND_ROLES;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Common;
import pages.Extras;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;

public class Test007_Changing_Permissions_Roles extends BaseClass{

    @Features("User management")
    @Test
    @Title("Changing permissions for the role")
    public void testChangePermissions() throws Exception {

        LoginUser.LoginProperly();

        Extras.ROLE_ADMINISTRATION().SelectRole("testrole");

        Extras.ROLE_ADMINISTRATION().selectGlobal();

        Extras.ROLE_ADMINISTRATION().CheckAllPermissions();

        Common.MAIN_MENU().clickSaveButton();

        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='footerForm:message']/dt")).isDisplayed());


    }
}
