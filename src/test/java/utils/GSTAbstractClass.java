package utils;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

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
    public static void setUpClass() throws Exception {


        String URL = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
        System.out.println(URL);
        Configuration.browser = Property_Loader.loadProperty("browser.name");
        open(URL);

        if ($(By.xpath(".//*[@id='loginForm']/table")).exists()) {
            Login.LoginProperly();
        }

        if ($(By.xpath(".//*[@id='countSessisionLimitForm:logout']")).isDisplayed()) {
            System.out.println("Licence limit for the count of concurrent sessions".toUpperCase());
            close();
            closeWebDriver();

        }

        $("#closeChangeSafetyConcept").waitUntil(enabled, 10000).click();

        $("#changeSafetyConceptPanelHeader").waitUntil(disappear, 8000);

        if ($("#changeSafetyConceptPanelHeader").isDisplayed()) {
            $("closeChangeSafetyConcept").click();
        }


    }

    @AfterTest
    public static void tearDownClass() {

        if ($(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).is(visible) || $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).is(enabled)) {
//            $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).waitUntil(present, 60000).waitUntil(enabled, 6000).click();
            executeJavaScript("gstool.doWithSaveWhenChanged(function(){fireOnClick('toolBarForm:logoutLink')});return false;;A4J.AJAX.Submit('toolBarForm',event,{'similarityGroupingId':'toolBarForm:logout','parameters':{'toolBarForm:logout':'toolBarForm:logout'} } );return false;");
        }

    }
}
