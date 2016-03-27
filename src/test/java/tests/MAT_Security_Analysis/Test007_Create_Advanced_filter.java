package tests.MAT_Security_Analysis;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

public class Test007_Create_Advanced_Filter extends GSTAbstractClass {


    @Features("Security Analysis")
    @Test
    @Title("Creating Advanced filter")
    public void testCreateCustomFilter() {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String TOname = "testBuilding";
        String filterName = "advancedFilter";
        String filter = "Target Object Subtype";
        String TOtype= "Building";

        // Click Add new Filter
        $(By.xpath(".//*[@id='dataListID:j_id279']/img")).waitUntil(enabled, 8000).click();

        // Navigate to Additional filters
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:j_id651_lbl']")).waitUntil(enabled, 8000).click();

        //Enter name of the filter
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:name']")).waitUntil(enabled, 8000).val(filterName);


        // Click New...
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:newCondition']")).waitUntil(enabled, 8000).click();

        // Select parameters
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_conditionPanel_Form:conditionField']")).selectOption(filter);
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_conditionPanel_Form:conditionValueDropDawn']")).selectOption(TOtype);
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_conditionPanel_Form:addLink']")).waitUntil(enabled, 8000).click();
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_conditionPanel_Form:addLink']")).waitUntil(disappear, 8000);

        // Select Global option
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:basicDataFilter']/table/tbody/tr[2]/td[2]/input")).setSelected(true);

        //Click save
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:commandSave']")).waitUntil(enabled, 8000).click();

        //Assertions
        $(By.partialLinkText(TOname)).shouldBe(visible, enabled);

        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_resetFilter_btn']/img")).waitUntil(enabled, 8000).click();
    }
}
