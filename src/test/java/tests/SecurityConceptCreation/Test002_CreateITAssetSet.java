package tests.SecurityConceptCreation;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;
import utils.Property_Loader;

public class Test002_CreateITAssetSet extends AbstractClass {

    @Before
    public void setUp() throws Exception {
        String InventoryAnalysis = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
        WebDriverRunner.getWebDriver().navigate().to(InventoryAnalysis);
    }

    @Test
    public void test001CreateItAssetSet() throws Exception {

        CreateNew.CreateTO("IT asset set", "Remote office", "Subtype");
    }

    @Test
    public void test002CreateTOs() throws Exception {

        CreateNew.CreateTO("Building", "Building_1", "Subtype");
        Thread.sleep(1000);
        CreateNew.CreateTO("Room", "Room_1", "Subtype");
        Thread.sleep(1000);
        CreateNew.CreateTO("Network", "Network_1", "Subtype");
    }

    @Test
    public void test003CreateTOs() throws Exception {

        CreateNew.CreateTO("IT system", "PC_1", "Subtype");
        Thread.sleep(1000);
        CreateNew.CreateTO("Application", "App_1", "Subtype");
        Thread.sleep(1000);
        CreateNew.CreateTO("Business process", "Process_1", "Subtype");

    }

    @Test
    public void test004CreateTOs() throws Exception {

        CreateNew.CreateTO("Information", "Info_1", "Subtype");
        Thread.sleep(1000);
        CreateNew.CreateTO("Employee", "Administrator", "Subtype");
        Thread.sleep(1000);
        CreateNew.CreateTO("Employee", "Boss", "Subtype");

    }
}
