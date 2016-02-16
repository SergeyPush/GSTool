package tests.MAT_Security_analysis;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;

public class Test002_QuickSearch_TO extends BaseClass{

    @Features("Security Analysis")
    @Test
    @Title("Quick search created TO")
    public void testSelectExistingTO() throws Exception {

        LoginUser.LoginProperly();

        String TOname = "testBuilding";

        GrundSchutz.SECURITY_ANALYSIS().quickSearchTO(TOname);

        Assert.assertTrue(driver.findElement(By.partialLinkText(TOname)).isEnabled());

    }
}
