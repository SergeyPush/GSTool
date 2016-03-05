package tests.SecurityConceptCreation;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import utils.Property_Loader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test002_CreateITAssetSet extends AbstractClass {

    String ITAsset1 = "Lawyer Agency";
    String Building1 = "Headquarters";
    String Room1 = "Main room";
    String Network1 = "Local network";
    String ItSystem1 = "PC";
    String Application1 = "Microsoft Office";
    String BusinessProcess1 = "Make money";
    String Information1 = "Database";
    String Employee1 = "Admin";
    String Employee2 = "Boss";


    @Before
    public void setUp() throws Exception {
        SelectView.OpenPage("IT-Grundschutz", "Inventory Analysis");
    }

    @Test
    public void test_001CreateItAssetSet() throws Exception {
        CreateNew.CreateTO("IT asset set", ITAsset1, null);
    }

    @Test
    public void test_002CreateBuilding() throws Exception {
        CreateNew.CreateTO("Building", Building1, ITAsset1);
    }

    @Test
    public void test_003CreateRoom() throws Exception {
        CreateNew.CreateTO("Room", Room1, ITAsset1);
    }

    @Test
    public void test_004CreateNetwork() throws Exception {
        CreateNew.CreateTO("Network", Network1, ITAsset1);
    }

    @Test
    public void test_005CreateITsystem() throws Exception {
        CreateNew.CreateTO("IT system", ItSystem1, ITAsset1);
    }

    @Test
    public void test_006CreateApplication() throws Exception {
        CreateNew.CreateTO("Application", Application1, ITAsset1);
    }

    @Test
    public void test_007CreateBusinessProcess() throws Exception {
        CreateNew.CreateTO("Business process", BusinessProcess1, ITAsset1);
    }

    @Test
    public void test_008CreateInformation() throws Exception {
        CreateNew.CreateTO("Information", Information1, ITAsset1);
    }

    @Test
    public void test_009CreateEmployee() throws Exception {
        CreateNew.CreateTO("Employee", Employee1, ITAsset1);
        Thread.sleep(1000);
        CreateNew.CreateTO("Employee", Employee2, ITAsset1);
    }

}
