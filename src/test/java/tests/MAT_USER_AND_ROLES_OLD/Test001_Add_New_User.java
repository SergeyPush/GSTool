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

public class Test001_Add_New_User extends BaseClass{



    public void AddNewUser() throws InterruptedException {

        LoginUser.LoginProperly();

        String username = RandomName.getRandomName();
        String password = RandomName.getRandomPassword();

        Extras.USER_ADMINISTRATION().addNewUser(username, password);

        Assert.assertTrue(driver.findElement(By.partialLinkText(username)).isDisplayed());
    }
}
