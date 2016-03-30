package com.infopulse.gst.autotest.utils;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GSTAbstractClass {

    public String Grundschutz = "IT-Grundschutz";
    public String SecurityCheck = "Security Check";
    public String InventoryAnalysis = "Inventory Analysis";
    public String SecurityAnalysis = "Security Analysis";
    public String RiskAnalysis = "Risk Analysis";

    public String UserAdministration = "User Administration";
    public String RoleAdministration = "Role Administration";

    public String normal = "normal";
    public String high = "high";
    public String veryHigh = "very high";

    @BeforeTest
    public static void setUpTest() throws Exception {


        String URL = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
        System.out.println(URL);
        Configuration.browser = Property_Loader.loadProperty("browser.name");
        open(URL);

        if ($(By.xpath(".//*[@id='loginForm']/table")).exists()) {
            Login.LoginProperly();
            SelectConcept.selectDefaultConcept();
        }

    }

    @AfterTest
    public static void tearDownTest() {

        if ($(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).is(visible) || $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).is(enabled)) {
//            $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).waitUntil(present, 60000).waitUntil(enabled, 6000).click();
            executeJavaScript("gstool.doWithSaveWhenChanged(function(){fireOnClick('toolBarForm:logoutLink')});return false;;A4J.AJAX.Submit('toolBarForm',event,{'similarityGroupingId':'toolBarForm:logout','parameters':{'toolBarForm:logout':'toolBarForm:logout'} } );return false;");
        }

    }
}
