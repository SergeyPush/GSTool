package com.infopulse.gst.autotest.MetadataManagement;

import com.codeborne.selenide.Configuration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class CreateSC {

    @Test
    public void testSCnew() throws Exception {

        Configuration.browser = "chrome";

        open("http://localhost:9090/gst2016/gstool");

        $("#j_username").val("admin");
        $("#j_password").val("gst12345");
        $("#j_submit").click();

        $(By.xpath(".//*[@id='closeChangeSafetyConcept']")).click();

        $(By.xpath(".//*[@id='topNaviForm:topNaviSelect']")).selectOption("Security Concepts");

        $(By.xpath(".//*[@id='newEnabled']")).click();

        $(By.xpath(".//*[@id='safetyConceptForm:newName']")).sendKeys("AutoSC");

        $(By.xpath(".//*[@id='saveEnabled']")).click();

        $(By.xpath(".//*[@id='creatingNew_SCVProgressForm:creatingSCVProgressBarData_body']/div")).waitUntil(text("Operation completed"), 10000000);

        $(By.xpath(".//*[@id='creatingNew_closeNewSCVCreation']")).click();

        $(By.xpath(".//*[@id='safetyConceptList_datalistScrollableContainer']")).waitUntil(text("AutoSC"), 10000);

        $(By.xpath(".//*[@id='safetyConceptList_datalistScrollableContainer']")).shouldBe(visible).shouldHave(text("AutoSC"));

        //Click Logout
        $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).click();


    }
}