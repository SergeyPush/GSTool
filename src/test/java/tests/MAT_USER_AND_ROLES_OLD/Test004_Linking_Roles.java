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


public class Test004_Linking_Roles extends BaseClass {


    public void Name() throws Exception {
        LoginUser.LoginProperly();

        String Username = RandomName.readFromFile().get(0);
        Extras.USER_ADMINISTRATION().AddyAdminRolle(Username);

        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='1']//td[4]/label"))
                .getText().contains("Adminrolle"));
    }
}
