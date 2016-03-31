package com.infopulse.gst.autotest.MetadataManagement;

import com.codeborne.selenide.Configuration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class GSTprereq {


    @BeforeClass
    public void setUpClass() throws Exception {

        Configuration.browser = "chrome";
        // Configuration.holdBrowserOpen = true;
        open("http://localhost:9090/gst2016/gstool");

        $("#j_username").val("admin");
        $("#j_password").val("gst12345");
        $("#j_submit").click();

        $(By.xpath(".//*[@id='changeSafetyConceptPanelContentDiv']")).waitUntil(visible, 10000);

        $(By.xpath(".//*[@id='changeSafetyConceptForm:safetyConceptGroupMenu']")).selectOption("AutoSC");

        $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).click();



    }


}