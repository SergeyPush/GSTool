package tests.MAT_Security_Analysis;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenPluses;
import utils.OpenView;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test003_Necessity_And_Proposal extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Change Necessity and Proposal")

    public void changeNecessityAndProposal() throws InterruptedException {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);
        OpenPluses.ExpandAll();

        String TOname = "testBuilding";

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
        $(By.xpath(".//*[@id='securityAnalysisForm:suggestionNecessityGrid']/tbody/tr/td[4]")).shouldHave(text("yes"));
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 15000).shouldHave(text("Successfully saved")).shouldHave(text(TOname));

    }
}

