package tests.MAT_Security_analysis;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Common;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;


public class Test004_Changing_Protection_Requirements extends BaseClass{

    @Features("Security Analysis")
    @Test
    @Title("Change Protection Requirements for selected TO")
    public void testChangePR() throws Exception {

        LoginUser.LoginProperly();

        String TOname = "testBuilding";
        GrundSchutz.SECURITY_ANALYSIS().SelectCreatedTO(TOname);

        String Confidentiality = "high";
        String Integrity = "high";
        String Availability = "high";
        String Description = "Some description";

        GrundSchutz.SECURITY_ANALYSIS().SetProtectionRequirement(Confidentiality, Integrity, Availability, Description);
        Common.MAIN_MENU().clickSaveButton();

        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='footerForm:message']/dt")).isDisplayed());

    }
}
