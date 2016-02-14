package tests.MAT_USER_AND_ROLES;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Extras;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;
import utils.OpenPlus;
import utils.RandomName;

public class Test003_Convert_User_To_Employee extends BaseClass {

    @Features("User management")
    @Test
    @Title("Convert Existing user to employee")
    public void testName() throws InterruptedException {

        LoginUser.LoginProperly();

        String Username = RandomName.readFromFile().get(0);

        Extras.USER_ADMINISTRATION().convertUserToEmployee(Username);

        OpenPlus.expandAll();
        Assert.assertTrue(driver.findElement(By.partialLinkText(Username)).isDisplayed());

    }
}
