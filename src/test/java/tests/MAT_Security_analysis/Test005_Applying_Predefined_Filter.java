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

public class Test005_Applying_Predefined_Filter extends BaseClass{

    @Features("Security Analysis")
    @Test
    @Title("Applying Predefined Filter")
    public void testApplyFilter() throws InterruptedException {

        LoginUser.LoginProperly();

        String FilterName = "Risk analysis required";
        String TOname = "testBuilding";

        GrundSchutz.SECURITY_ANALYSIS().SelectPredefinedFilter(FilterName);

        Assert.assertTrue(driver.findElements(By.partialLinkText(TOname)).size()>0);

    }
}
