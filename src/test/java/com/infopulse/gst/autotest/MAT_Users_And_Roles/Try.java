package com.infopulse.gst.autotest.MAT_Users_And_Roles;


import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenView;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class Try extends GSTAbstractClass {

    @DataProvider(name = "afilters")
    Object[][] afilters() {
        return new Object[][]{
                {"Audit question-description", "exactly", "descrition"},
                {"Audit question-description", "except", "descrition"},
                {"Audit question-description", "including", "descrition"},
                {"Audit question-description", "excluding", "descrition"},
                {"Audit question-description", "empty", null},
                {"Audit question-description", "not empty", null},
                {"Audit question-answer", "exactly", "Yes"},
                {"Audit question-answer", "exactly", "No"},
                {"Audit question-answer", "exactly", "Partially"},
                {"Safeguard-required from", "exactly", "A-Entry level"},
                {"Safeguard-last audit by", "exactly", "Admin"}
        };
    }



    @Test(dataProvider = "afilters")
    public void testTryFilters(String filter, String operation, String value) throws Exception {
        OpenView.NavigateTO(Grundschutz, SecurityCheck);
        //open filters
        $(By.xpath(".//*[@id='extendedDataListForm:j_id305']/img")).waitUntil(enabled, 8000).click();
        $(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:j_id677_lbl']")).waitUntil(enabled, 8000).click();
        $(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:name']")).waitUntil(enabled, 6000).val("Test filter2");
        $(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:newCondition']")).waitUntil(enabled, 8000).click();

        //.//*[@id='securityCheckFilterPanel_conditionPanel_Form']/table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']
        //table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']
        //table//select[@style='display:inline']

        String selector = "//table//select[@style='display:inline'] | //table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']";

        $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).waitUntil(enabled, 8000).selectOption(filter);
        Thread.sleep(500);
        $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionOperator']")).waitUntil(enabled, 6000).selectOption(operation);
        Thread.sleep(500);
        if (value != null) {
            $(By.xpath(selector)).sendKeys(value);
            Thread.sleep(500);
        }

        //ok, save
        $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:addLink']")).click();
        $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanelHeader']")).waitUntil(disappears, 4000);

        $(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:commandSave']")).click();
        $(By.xpath(".//*[@id='securityCheckFilterPanelHeader']")).waitUntil(disappears, 5000);

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        if($(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:filterMessage']//span[contains(text(), 'An error occurred')]")).isDisplayed()){
            refresh();
            $(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:filterMessage']//span[contains(text(), 'An error occurred')]")).waitUntil(disappear, 8000);
        } else if ($(By.xpath("//span[contains(text(), 'Mandatory')]")).isDisplayed()){
            refresh();
        }

        $(By.xpath(".//*[@id='extendedDataListForm:filter_to_dataList_filter_management']/tbody/tr/td[3]/a[1]/img")).waitUntil(visible, 6000).click();
        $(By.xpath(".//*[@id='confirmationDialog-confirm']")).waitUntil(enabled, 8000).click();
        $(By.xpath(".//*[@id='confirmationDialogHeader']")).waitUntil(disappears, 6000);

    }
}
