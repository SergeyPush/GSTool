package tests.MAT_Security_Analysis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class Test009_Delete_Custom_Filter extends GSTAbstractClass{

    @Test
    @Title("Delete custom filter")
    public void testDeleteCustomFilter1() throws Exception {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String TOname = "testBuilding";
        String filterName = "CustomFilter";
        String TOtype = "Building";
        String newFilterName = "ChangedFilter";

        //Select created filter
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[1]/select")).selectOption("g"+newFilterName);

        //Click Remove filter button
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[3]/a[1]")).click();

        // Confirm Deletion
        $("#confirmationDialog-confirm").waitUntil(enabled, 10000).click();

        //Assertions
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[1]/select")).waitUntil(visible, 10000).shouldHave(text("All"));

    }
    @Test
    @Title("Delete changed filter")
    public void testDeleteCustomFilter2() throws Exception {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String TOname = "testBuilding";
        String filterName = "CustomFilter";
        String TOtype = "Building";
        String newFilterName = "changedFilter";

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
