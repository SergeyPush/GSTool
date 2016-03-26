package tests.SecurityConceptCreation;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.SecurityConceptCreation.utils.AbstractClass;
import utils.OpenView;
import utils.TargetObject;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;


public class Test002_CreateITAssetSet extends AbstractClass {

    public String ITAsset = "Lawyer Agency";
    public String Building1 = "Headquarters";
    public String Building2 = "Remote Office";
    public String Room = "Main room";
    public String Network = "Local network";
    public String ItSystem = "PC";
    public String Application = "Microsoft Office";
    public String BusinessProcess = "Make money";
    public String Information = "Database";
    public String Employee1 = "Admin";
    public String Employee2 = "Boss";

    String ToDescription = "Some description";

    @BeforeClass
    public void setUp() throws Exception {
        OpenView.NavigateTO("IT-Grundschutz", "Inventory Analysis");
    }

    @Test
    public void test_001CreateItAssetSet() throws Exception {
        TargetObject.CreateNew("IT asset set", ITAsset, null);
    }

    @Test
    public void test_002CreateBuilding() throws Exception {
        TargetObject.CreateNew("Building", Building1, ITAsset);

        TargetObject.CreateNew("Building", Building2, ITAsset);
    }

    @Test
    public void test_003CreateRoom() throws Exception {
        TargetObject.CreateNew("Room", Room, ITAsset);
    }

    @Test
    public void test_004CreateNetwork() throws Exception {
        TargetObject.CreateNew("Network", Network, ITAsset);
    }

    @Test
    public void test_005CreateITsystem() throws Exception {
        TargetObject.CreateNew("IT system", ItSystem, ITAsset);
    }

    @Test
    public void test_006CreateApplication() throws Exception {
        TargetObject.CreateNew("Application", Application, ITAsset);
    }

    @Test
    public void test_007CreateBusinessProcess() throws Exception {
        TargetObject.CreateNew("Business process", BusinessProcess, ITAsset);
    }

    @Test
    public void test_008CreateInformation() throws Exception {
        TargetObject.CreateNew("Information", Information, ITAsset);
    }

    @Test
    public void test_009CreateEmployee() throws Exception {
        TargetObject.CreateNew("Employee", Employee1, ITAsset);

        TargetObject.CreateNew("Employee", Employee2, ITAsset);
    }

    @Test
    public void test_010Logout() {
        if ($(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).waitUntil(enabled, 6000).isDisplayed()) {
            $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).click();
        }
    }

}
