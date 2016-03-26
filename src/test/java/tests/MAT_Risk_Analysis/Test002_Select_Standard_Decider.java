package tests.MAT_Risk_Analysis;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenPluses;
import utils.OpenView;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test002_Select_Standard_Decider extends GSTAbstractClass{

    @Features("Risk Analysis")
    @Test
    @Title("Select standard decider")
    public void selectStandardDecider() throws Exception {

        OpenView.NavigateTO(Grundschutz, RiskAnalysis);

        String TOname = "riskBuilding";
        String date = "23.03.2016";

        // Select TO
        OpenPluses.ExpandAll();
        $(By.partialLinkText(TOname)).click();

        // Select decider
        $(By.xpath(".//*[@id='riskAnalysisForm:dfsPanel_deciderButton']")).waitUntil(enabled, 8000).click();
        $(By.xpath(".//*[@id='deciderForSecurityAnalysisForm:deciderForSecurityAnalysis_personTable:0:deciderForSecurityAnalysisstate0_fake']")).setSelected(true);
        $(By.xpath(".//*[@id='deciderForSecurityAnalysisForm:deciderForSecurityAnalysisokLink']")).click();

        // Enter date and signature
        $(By.xpath(".//*[@id='riskAnalysisForm:dfsPanel_deciderTable:0:decisionDateInputDate']")).val(date);
        $(By.xpath(".//*[@id='riskAnalysisForm:dfsPanel_deciderTable:0:signature']")).selectOption("yes");


        // Click Save button
        $("#saveEnabled").click();

        //Asserts
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 10000);
        $$(By.xpath(".//*[@id='riskAnalysisForm:dfsPanel_deciderTable:tb']/tr")).shouldHave(CollectionCondition.size(1));
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).shouldHave(text("uccessfully saved")).shouldHave(text(TOname));

    }
}
