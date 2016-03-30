package com.infopulse.gst.autotest.SecurityConceptCreation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenView;
import com.infopulse.gst.autotest.utils.TargetObject;


public class Test002_CreateITAssetSet extends GSTAbstractClass {

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

    @Title("Create IT set")
    @BeforeMethod
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


}
