package tests.MAT_Security_analysis_OLD;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.*;


public class Test001_SelectCreatedTO extends BaseClass {


    public void SelectExistingTO() throws Exception {

        LoginUser.LoginProperly();
        OpenPage.SelectView(IT_Grundscutz, Inventory_Analysis);

        String TOname = "testBuilding";

        ToCreation.CreateNewTO("Building");
        GrundSchutz.SECURITY_ANALYSIS().SelectCreatedTO(TOname);

        Assert.assertTrue(driver.findElement(By.partialLinkText(TOname)).isDisplayed());

    }
}
