package tests.MAT_Security_Analysis;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

public class Test006_Creating_Custom_Filter extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Creating user filter")
    public void testCreateCustomFilter() {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String TOname = "testBuilding";
        String filterName = "testFilter";
        String TOsubtype= "[general building]";
        String TOtype = "Building";

        //Click Add new Filter
        $(By.xpath(".//*[@id='dataListID:j_id279']/img")).click();

        //Enter filtering parameters
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:name']")).val(filterName);
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:conditionGroup:0:basicConditionFacade:0:basicConditionValueDropDawn']")).selectOption(TOsubtype);

        //Click Execute button:
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:commandExecute']")).waitUntil(enabled, 6000).click();

        //Assertions
        $(By.partialLinkText(TOname)).shouldBe(visible, enabled);


    }
}
