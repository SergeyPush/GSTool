package workshop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import workshop.pages.InventoryAnalysisPage;
import workshop.pages.LoginPage;

public class CreateBuilding extends Abstract{


    @Test
    public void testName() throws Exception {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("automan", "a12345678");
        InventoryAnalysisPage inventoryAnalysis = loginPage.selectDefaultConcept();
        inventoryAnalysis.createNewBuilding("Mc Donalds", "MC DONALDS");



        //Assert
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='footerForm:message']/dt/span")).getText().contains("Successfully saved"));

    }

}
