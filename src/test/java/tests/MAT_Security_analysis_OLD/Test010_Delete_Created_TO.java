package tests.MAT_Security_analysis_OLD;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Common;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;


public class Test010_Delete_Created_TO extends BaseClass {

    @Features("Security Analysis")
    @Test
    @Title("Delete Created TO ")
    public void testDeleteCreatedTO() throws Exception {

        LoginUser.LoginProperly();

        String TOname = "testBuilding";
        GrundSchutz.INVENTORY_ANALYSIS().SelectToName(TOname);
        Common.MAIN_MENU().clickDeleteButton();

        Assert.assertTrue("TO wasn't deleted successfully", driver.findElement(By.xpath(".//*[@id='footerForm:message']/dt")).isDisplayed());

    }
}
