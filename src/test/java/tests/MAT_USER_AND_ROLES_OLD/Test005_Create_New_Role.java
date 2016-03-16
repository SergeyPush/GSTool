package tests.MAT_USER_AND_ROLES_OLD;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Extras;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;
import utils.RandomName;


public class Test005_Create_New_Role extends BaseClass {

    @Features("User management")
    @Test
    @Title("Create new role")
    public void testCreateNewRole() throws Exception {

        LoginUser.LoginProperly();

        String roleName = RandomName.getRandomRoleName();

        Extras.ROLE_ADMINISTRATION().CreateNewRole(roleName);

        Assert.assertTrue(driver.findElement(By.partialLinkText(roleName)).isDisplayed());

    }
}
