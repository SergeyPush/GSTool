package com.infopulse.gst.autotest.MAT_Users_And_Roles;


import com.codeborne.selenide.Condition;
import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenView;
import com.infopulse.gst.autotest.utils.RandomName;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Try extends GSTAbstractClass{

    @DataProvider(name = "afilters")
    Object[][] afilters(){
        return new Object[][]{
                {"Audit question-description", "exactly", "descrition"},
                {"Audit question-description", "except", "descrition"},
                {"Audit question-description", "including", "descrition"},
                {"Audit question-description", "excluding", "descrition"},
                {"Audit question-description", "empty", null},
                {"Audit question-description", "not empty", null},
                {"Audit question-answer","exactly","Yes"},
                {"Audit question-answer","exactly","No"},
                {"Audit question-answer","exactly","Partially"}
        };
    }


    @Test
    public void openFilters(){

        OpenView.NavigateTO(Grundschutz, SecurityCheck);
        $(By.xpath(".//*[@id='extendedDataListForm:j_id305']/img")).waitUntil(enabled, 8000).click();
        $(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:j_id677_lbl']")).waitUntil(enabled, 8000).click();
        $(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:name']")).waitUntil(enabled, 6000).val("Test filter");
        $(By.xpath(".//*[@id='securityCheckFilterPanel_dataListFilterForm:newCondition']")).waitUntil(enabled, 8000).click();
    }

    @Test(dataProvider = "afilters", dependsOnMethods = "openFilters")
    public void testTryFilters(String filter, String operation, String value) throws Exception {

        //.//*[@id='securityCheckFilterPanel_conditionPanel_Form']/table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']
        //table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']
        //table//select[@style='display:inline']

        String selector = "//table//select[@style='display:inline'] | //table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']";

        $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).waitUntil(enabled, 8000).selectOption(filter);
        Thread.sleep(500);
        $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionOperator']")).waitUntil(enabled, 6000).selectOption(operation);
        Thread.sleep(500);
        if (value!=null){
            $(By.xpath(selector)).sendKeys(value);
            Thread.sleep(500);
        }

        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Count");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("count");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Employee-e-mail");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("mail");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Employee-first name");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("name");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Employee-mobile phone");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Phone");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Employee-organisational unit");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("O unit");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Employee-phone");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("phone");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Interview-content");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Content");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Interview-Date");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("01.01.2016");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Interview-Description");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Description");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("IT-Asset-Auditor");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Auditor");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("IT-Asset-authorized at");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Authorised");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("IT-Asset-Contractual basis");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Basis");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("IT-Asset-Distributions list");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("List");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("IT-Asset-Inspect reference document");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("document");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("IT-Asset-Object under investigation");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("investigation");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("IT-Asset-Projection");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Projection");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Module-explanation");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("explanation");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Module-metadata text");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("metadata");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Module-name");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Module");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Module-number");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Number");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Name");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Name");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Room-floor");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Floor");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Room-number");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Room");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Expected Material costs fix");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Cost");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Expected Material costs variable");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Variable");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Expected Personal costs fix");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Fix");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Expected personal costs variable");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Variable");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Explanation");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Explanation");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-last audit on");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("01.01.2015");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-metadata text");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Text");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-name");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Name");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Next audit on");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("01.02.2016");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Projectplanning");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Planning");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-realization begins on");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("02.02.2016");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-realization ends on");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("03.03.2016");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Remarks");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Remarks");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Spent material costs fix");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Cost fix");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Safeguard-Spent personal costs variable");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Variable");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Threat-name");
        // Thread.sleep(1000);
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Threat");
        // Thread.sleep(1000);
        //
        // $(By.xpath(".//*[@id='securityCheckFilterPanel_conditionPanel_Form:conditionField']")).selectOption("Token");
        //
        // $(By.xpath("//table//div[@style='display:inline' or @style='display:inline; white-space:nowrap']//input[@type='text']")).val("Token");
        // Thread.sleep(1000);


    }

}
