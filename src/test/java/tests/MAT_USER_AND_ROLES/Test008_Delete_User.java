package tests.MAT_USER_AND_ROLES;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Extras;
import utils.BaseClass;
import utils.LoginUser;
import utils.RandomName;

public class Test008_Delete_User extends BaseClass{

    @Test
    public void testDeleteUser(){

        LoginUser.LoginProperly();

        String Username = RandomName.readFromFile().get(0);
        Extras.USER_ADMINISTRATION().deleteUser(Username);

        Assert.assertTrue(driver.findElements(By.linkText(Username)).size()==0);

    }
}
