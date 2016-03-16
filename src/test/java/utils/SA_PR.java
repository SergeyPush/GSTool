package utils;

import org.openqa.selenium.By;
import tests.SecurityConceptCreation.utils.AbstractClass;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SA_PR extends AbstractClass {

    public static void setPrDefinitions() {

        $("#targetObjectForm:tabProtectionRequirementDefinitions_lbl").click();

        //-- Confidentiality --


        //-- Integrity --
        //-- Availability --

    }

    public static void setPRforTO(String confidentiality, String integrity, String availability, String text) throws InterruptedException {


        $(By.xpath(".//*[@id='securityAnalysisForm:protectionRequirementTab_lbl']")).click();

        //-- Set Confidentiality --
        $(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:0:category']")).selectOption(confidentiality);
        Thread.sleep(500);
        $(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:0:reason']")).waitUntil(enabled, 6000).setValue(text + " for " + confidentiality + " confidentiality");


        //-- Set Integrity --
        $(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:1:category']")).selectOption(integrity);
        Thread.sleep(500);
        $(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:1:reason']")).setValue(text + " for " + integrity + " integrity");

        //-- Set Availability --
        $(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:2:category']")).selectOption(availability);
        Thread.sleep(500);
        $(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:2:reason']")).setValue(text + " for " + integrity + " availability");

        //Click save button
        $(By.xpath(".//*[@id='saveEnabled']")).waitUntil(enabled, 6000).click();

        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 15000).shouldHave(text("Successfully saved"));
    }





}
