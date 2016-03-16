package tests.MAT_USER_AND_ROLES_OLD;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Extras;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;


public class Test009_Delete_Created_Role extends BaseClass{

    @Features("User management")
    @Test
    @Title("Delete created role")
    public void testDeleteRole() throws Exception {

        LoginUser.LoginProperly();

        Extras.ROLE_ADMINISTRATION().DeleteCreatedRole();

        Assert.assertFalse(driver.findElements(By.partialLinkText("testrole")).isEmpty());

        GrundSchutz.INVENTORY_ANALYSIS().SelectToName("testuser");

    }
}
