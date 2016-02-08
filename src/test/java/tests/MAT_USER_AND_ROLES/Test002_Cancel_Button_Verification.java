package tests.MAT_USER_AND_ROLES;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Extras;
import utils.BaseClass;
import utils.LoginUser;
import utils.RandomName;

/**
 * Created by sergey on 08.02.16.
 */
public class Test002_Cancel_Button_Verification extends BaseClass{

    @Test
    public void testCancelButtonVerification(){
        LoginUser.LoginProperly();
        String name = RandomName.readFromFile().get(0);
        String password = "Some_password";

        Extras.USER_ADMINISTRATION().editUserPassword(name, password);

        Assert.assertFalse(driver.findElement(By.xpath(".//*[@id='footerForm:message']")).isDisplayed());


    }
}
