package tests.MAT_Security_Analysis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test008_Save_Custom_filter_As extends GSTAbstractClass {

    @Features("Security Analysis")
    @Test
    @Title("Save custom Filter As")
    public void testSaveFilterAs() throws Exception {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String TOname = "testBuilding";
        String filterName = "CustomFilter";
        String TOtype = "Building";
        String newFilterName = "ChangedFilter";


        // Select Filter
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[1]/select")).selectOption("g" + filterName);

        // Click Edit filter button
        $(By.xpath(".//*[@id='dataListID:j_id295']/img")).click();

        // Add parameters
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:conditionGroup:0:basicConditionFacade:4:basicConditionValueDropDawn']")).selectOption(TOtype);

        // Enter new Filter name
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:name']")).val(newFilterName);

        // Click Save filter as button
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:commandSaveAs']")).waitUntil(enabled, 8000).click();

        //Assertions
        $(By.partialLinkText(TOname)).shouldBe(visible, enabled);

        //Reset Filter
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_resetFilter_btn']/img")).waitUntil(enabled, 8000).click();
    }
}
