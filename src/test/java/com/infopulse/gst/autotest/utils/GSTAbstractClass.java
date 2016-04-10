package com.infopulse.gst.autotest.utils;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GSTAbstractClass {

    protected String Grundschutz = "IT-Grundschutz";
    protected String SecurityCheck = "Security Check";
    protected String InventoryAnalysis = "Inventory Analysis";
    protected String SecurityAnalysis = "Security Analysis";
    protected String RiskAnalysis = "Risk Analysis";

    protected String UserAdministration = "User Administration";
    protected String RoleAdministration = "Role Administration";

    protected String normal = "normal";
    protected String high = "high";
    protected String veryHigh = "very high";

    @BeforeTest
    public static void setUpTest() throws Exception {


        String URL = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
        System.out.println(URL);
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = Property_Loader.loadProperty("browser.name");
        open(URL);

        if ($(By.xpath(".//*[@id='loginForm']/table")).exists()) {
            Login.LoginProperly();
            SelectConcept.selectDefaultConcept();
        }
    }

    @BeforeClass
    public void setUpClass() {
        if ($(".header-table>tbody>tr>td>img").isDisplayed()) {

        } else if ($("#loginForm").isDisplayed()) {
            Login.LoginProperly();
            SelectConcept.selectDefaultConcept();

        } else {
            refresh();
        }
    }

    @AfterTest
    public static void tearDownTest() {

        if ($(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).isEnabled()) {
            executeJavaScript("gstool.doWithSaveWhenChanged(function(){fireOnClick('toolBarForm:logoutLink')});return false;;A4J.AJAX.Submit('toolBarForm',event,{'similarityGroupingId':'toolBarForm:logout','parameters':{'toolBarForm:logout':'toolBarForm:logout'} } );return false;");
        }

    }
}
