package com.infopulse.gst.autotest.MAT_Security_Analysis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenView;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Test006_Creating_Temporary_Filter extends GSTAbstractClass{

    @Test
    @Title("Creating temporary filter using Execute button")
    public void testCreateTempFilter() {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String TOname = "testBuilding";
        String filterName = "tempFilter";
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

        //Reset filter
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_resetFilter_btn']/img")).waitUntil(enabled, 8000).click();
    }
}
