package tests.MAT_Security_Analysis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class Test011_Delete_Advanced_Filter extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Delete custom advanced filter")
    public void testDeleteCustomFilter1() throws Exception {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String filterName = "AdvancedFilter";

        //Select created filter
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[1]/select")).selectOption("g"+filterName);

        //Click Remove filter button
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[3]/a[1]")).click();

        // Confirm Deletion
        $("#confirmationDialog-confirm").waitUntil(enabled, 10000).click();

        //Assertions
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[1]/select")).waitUntil(visible, 10000).shouldHave(text("All"));

    }




}
