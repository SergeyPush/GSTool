package tests.MAT_Security_analysis;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Common;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.*;


public class Test001_SelectCreatedTO extends BaseClass{

    @Features("Security Analysis")
    @Test
    @Title("Test create new user")
    public void testSelectExistingTO() throws Exception {

        LoginUser.LoginProperly();
        OpenPage.SelectView(IT_Grundscutz, Inventory_Analysis);

        String TOname = "testBuilding";

        ToCreation.CreateNewTO("Building");
        GrundSchutz.SECURITY_ANALYSIS().SelectCreatedTO(TOname);

        Assert.assertTrue(driver.findElement(By.partialLinkText(TOname)).isDisplayed());

    }
}
