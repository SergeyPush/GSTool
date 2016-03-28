package tests.MAT_Security_Analysis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Test007_Creating_Custom_Filter extends GSTAbstractClass{

    @Test
    @Title("Creating Custom filter")
    public void testCreateCustomFilter() {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String TOname = "testBuilding";
        String filterName = "CustomFilter";
        String TOsubtype= "[general building]";

        //Click Add new Filter
        $(By.xpath(".//*[@id='dataListID:j_id279']/img")).click();

        // Select Global option
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:basicDataFilter']/table/tbody/tr[2]/td[2]/input")).setSelected(true);

        //Enter filtering parameters
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:name']")).val(filterName);
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:conditionGroup:0:basicConditionFacade:0:basicConditionValueDropDawn']")).selectOption(TOsubtype);

        //Click Save button:
        $(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:commandSave']")).waitUntil(enabled, 6000).click();

        //Assertions
        $(By.partialLinkText(TOname)).shouldBe(visible, enabled);

        //Reset filter
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_resetFilter_btn']/img")).waitUntil(enabled, 8000).click();

    }
}
