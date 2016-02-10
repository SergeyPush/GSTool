package tests.MAT_USER_AND_ROLES;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Extras;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;
import utils.RandomName;

public class Test010_Delete_User extends BaseClass{

    @Test
    @Features("User management")
    @Title("Delete existing user")
    public void testDeleteUser(){

        LoginUser.LoginProperly();

        String Username = RandomName.readFromFile().get(0);
        Extras.USER_ADMINISTRATION().deleteUser(Username);

        Assert.assertTrue(driver.findElements(By.partialLinkText(Username)).isEmpty());

    }
}
