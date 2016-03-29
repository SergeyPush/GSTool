package tests.MAT_Risk_Analysis;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.GSTAbstractClass;
import utils.OpenPluses;
import utils.OpenView;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Test003_Set_Sufficient_Protection extends GSTAbstractClass {

    @Test
    public void testSetSufficientProtection() throws Exception {

        OpenView.NavigateTO(Grundschutz, RiskAnalysis);

        String TOname = "riskBuilding";
        String SufficientProtection = "yes";
        String Description = "Some description";

        OpenPluses.ExpandAll();
        $(By.partialLinkText(TOname)).click();

        $(By.xpath(".//*[@id='RiskAnalysisDataList']/div[1]/table/tbody/tr/td/select")).selectOption("Threat open");

        Thread.sleep(3000);
        ElementsCollection list = $$(By.xpath("//a[contains(text(), 'T ')]"));

        for (SelenideElement element : list) {
            Thread.sleep(500);
            element.waitUntil(enabled, 6000).click();
            Thread.sleep(1500);
            $(By.xpath(".//*[@id='riskAnalysisForm:enough']")).waitUntil(enabled, 8000).selectOption(SufficientProtection);
            $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(visible, 8000);

            $(By.xpath(".//*[@id='riskAnalysisForm:enoughReason']")).val(Description);

            $("#saveEnabled").waitUntil(enabled, 8000).click();

            $(By.xpath(".//*[@id='footerForm:message']/dt")).waitUntil(present, 8000);

            if ($("#genericConfirmPanelHeader").isDisplayed()) {
                $("#genericConfirmPanelNo").click();
                $("#genericConfirmPanelHeader").waitUntil(disappears, 8000);
            }
        }
    }
}
