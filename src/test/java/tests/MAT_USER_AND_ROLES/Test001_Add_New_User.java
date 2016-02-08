package tests.MAT_USER_AND_ROLES;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Extras;
import utils.BaseClass;
import utils.LoginUser;
import utils.RandomName;

public class Test001_Add_New_User extends BaseClass{


    @Test
    public void testAddNewUser() {

        LoginUser.LoginProperly();

        String username = RandomName.getRandomName();
        String password = RandomName.getRandomPassword();

        Extras.USER_ADMINISTRATION().addNewUser(username, password);

        Assert.assertTrue(driver.findElement(By.partialLinkText(username)).isDisplayed());
    }
}
