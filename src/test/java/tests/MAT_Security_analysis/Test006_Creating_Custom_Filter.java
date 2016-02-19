package tests.MAT_Security_analysis;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;

public class Test006_Creating_Custom_Filter extends BaseClass{

    @Features("Security Analysis")
    @Test
    @Title("Creating user filter")
    public void testName() throws Exception {

        LoginUser.LoginProperly();

        String TOname = "testBuilding";
        String filterName = "testFilter";
        String TOsubtype= "[general building]";
        String TOtype = "Building";

        GrundSchutz.SECURITY_ANALYSIS().creaateNewFilter(filterName, TOsubtype, TOtype);

        Assert.assertTrue(driver.findElements(By.partialLinkText(TOname)).size()>0);

    }
}
