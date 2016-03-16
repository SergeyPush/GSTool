package utils;


import com.codeborne.selenide.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GSTAbstractClass {

    public String Grundschutz = "IT-Grundschutz";
    public String SecurityCheck = "Security Check";
    public String InventoryAnalysis = "Inventory Analysis";
    public String SecurityAnalysis = "Security Analysis";

    public String UserAdministration = "User Administration";
    public String RoleAdministration = "Role Administration";

    public String normal = "normal";
    public String high = "high";
    public String veryHigh = "very high";

    @BeforeClass
    public static void setUpClass() throws Exception {

        String URL = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
        System.out.println(URL);
//        Configuration.browser = "chrome";
        open(URL);

        if ($(By.xpath(".//*[@id='loginForm']/table")).exists()) {
            Login.LoginProperly();
        }

        $("#closeChangeSafetyConcept").waitUntil(enabled, 10000).click();

        $("#changeSafetyConceptPanelHeader").waitUntil(disappear, 8000);

        if ($("#changeSafetyConceptPanelHeader").isDisplayed()){
            $("closeChangeSafetyConcept").click();
        }


    }

    @AfterClass
    public static void tearDownClass() {

        if ($(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).exists()){
            $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).click();
        }
    }
}
