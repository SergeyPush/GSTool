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


public class Test002_Cancel_Button_Verification extends BaseClass{

    @Test
    @Features("User management")
    @Title("Test cancel button verification")

    public void testCancelButtonVerification() throws InterruptedException {
        LoginUser.LoginProperly();
        String name = RandomName.readFromFile().get(0);
        String password = "Some_password";

        Extras.USER_ADMINISTRATION().editUserPassword(name, password);

        Assert.assertFalse(driver.findElement(By.xpath(".//*[@id='footerForm:message']")).isDisplayed());


    }
}
