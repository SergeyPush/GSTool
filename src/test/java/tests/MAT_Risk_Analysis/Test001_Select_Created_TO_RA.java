package tests.MAT_Risk_Analysis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenPluses;
import utils.OpenView;
import utils.TargetObject;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Test001_Select_Created_TO_RA extends GSTAbstractClass {

    public String TOname = "riskBuilding";

    @Features("Risk Analysis")
    @Test
    @Title("Test create new TO and verify it in RA")
    public void testSelectCreatedTO1() throws Exception {


        OpenView.NavigateTO(Grundschutz, InventoryAnalysis);

        //Create Building

        TargetObject.CreateNew("Building", TOname, "Lawyer Agency");

        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 10000).shouldHave(text("Successfully saved")).shouldHave(text(TOname));

        //Find building in SA
        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);
        OpenPluses.ExpandAll();
        $(By.partialLinkText(TOname)).shouldBe(visible).shouldHave(text(TOname));


        //Fill SA:
        $(By.partialLinkText(TOname)).click();
        // Set Special use case to Yes
        $(By.xpath(".//*[@id='securityAnalysisForm:scenario:0']")).waitUntil(enabled, 6000).click();

        // Set Necessity of a Risk Analysis to Yes
        $(By.xpath(".//*[@id='securityAnalysisForm:necessity']")).selectOption("yes");

        //Select Decider
        $(By.xpath(".//*[@id='securityAnalysisForm:decisionUser']")).selectOption(1);

        //Enter date of decision
        $(By.xpath(".//*[@id='securityAnalysisForm:decisionDateInputDate']")).val("16.03.2016");

        //Enter Some Description
        String description = "Some description";
        $(By.xpath(".//*[@id='securityAnalysisForm:necessityReason']")).val(description);

        //Click Save button
        $("#saveEnabled").click();

        Thread.sleep(1000);

        //Assertions
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 15000).shouldHave(text("Successfully saved")).shouldHave(text(TOname));

    }


    @Features("Risk Analysis")
    @Test
    @Title("Test create new TO and verify it in RA")
    public void testSelectCreatedTO2() throws Exception {
        //Navigate to RA find created TO
        OpenView.NavigateTO(Grundschutz, RiskAnalysis);

        OpenPluses.ExpandAll();
        $(By.partialLinkText(TOname)).shouldBe(visible).shouldHave(text(TOname));
    }
}
