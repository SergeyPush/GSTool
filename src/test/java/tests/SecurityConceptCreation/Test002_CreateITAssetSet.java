package tests.SecurityConceptCreation;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import tests.SecurityConceptCreation.utils.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test002_CreateITAssetSet extends AbstractClass {

    String ITAsset = "Lawyer Agency";
    String Building1 = "Headquarters";
    String Building2 = "Remote Office";
    String Room = "Main room";
    String Network = "Local network";
    String ItSystem = "PC";
    String Application = "Microsoft Office";
    String BusinessProcess = "Make money";
    String Information = "Database";
    String Employee1 = "Admin";
    String Employee2 = "Boss";

    String ToDescription = "Some description";

    @Before
    public void setUp() throws Exception {
        SelectView.OpenPage("IT-Grundschutz", "Inventory Analysis");
    }

    @Test
    public void test_001CreateItAssetSet() throws Exception {
        CreateNew.CreateTO("IT asset set", "Lawyer Agency", null);
    }

    @Test
    public void test_002CreateBuilding() throws Exception {
        CreateNew.CreateTO("Building", Building1, ITAsset);
        PR.setPRforTO(normal, high, veryHigh, ToDescription);

        CreateNew.CreateTO("Building", Building2, ITAsset);
        PR.setPRforTO(high, normal, normal, ToDescription);
    }

    @Test
    public void test_003CreateRoom() throws Exception {
        CreateNew.CreateTO("Room", Room, ITAsset);
    }

    @Test
    public void test_004CreateNetwork() throws Exception {
        CreateNew.CreateTO("Network", Network, ITAsset);
    }

    @Test
    public void test_005CreateITsystem() throws Exception {
        CreateNew.CreateTO("IT system", ItSystem, ITAsset);
    }

    @Test
    public void test_006CreateApplication() throws Exception {
        CreateNew.CreateTO("Application", Application, ITAsset);
    }

    @Test
    public void test_007CreateBusinessProcess() throws Exception {
        CreateNew.CreateTO("Business process", BusinessProcess, ITAsset);
    }

    @Test
    public void test_008CreateInformation() throws Exception {
        CreateNew.CreateTO("Information", Information, ITAsset);
    }

    @Test
    public void test_009CreateEmployee() throws Exception {
        CreateNew.CreateTO("Employee", Employee1, ITAsset);

        CreateNew.CreateTO("Employee", Employee2, ITAsset);
    }

    @Test
    public void test_010Logout() {
        if ($(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).waitUntil(enabled, 6000).isDisplayed()) {
            $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).click();
        }
    }

}
