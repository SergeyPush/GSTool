package tests.MAT_Security_analysis;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.LoginUser;

public class Test003_Necessity_And_Proposal extends BaseClass {


    @Features("Security Analysis")
    @Test
    @Title("Change Necessity and Proposal")
    public void testChangeToStatus() throws Exception {


        LoginUser.LoginProperly();

        String TOname = "testBuilding";
        GrundSchutz.SECURITY_ANALYSIS().SelectCreatedTO(TOname);

        String NecessityOfRA = "yes";
        String Decider = "Administrator";
        String DateOfDecision = "18.02.2016";
        String Explanation = "Some explanation";

        GrundSchutz.SECURITY_ANALYSIS().ChangeNecessity(NecessityOfRA, Decider, DateOfDecision, Explanation);

        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='footerForm:message']/dt")).isDisplayed());
    }
}
