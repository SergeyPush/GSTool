package tests.SecurityConceptCreation.utils;

import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PR extends AbstractClass {

    public static void setPrDefinitions() {

        $("#targetObjectForm:tabProtectionRequirementDefinitions_lbl").click();

        //-- Confidentiality --


        //-- Integrity --
        //-- Availability --

    }

    public static void setPRforTO(String confidentiality, String integrity, String availability, String text) {


        $(By.xpath(".//*[@id='targetObjectForm:tabProtectionRequirement_lbl']")).click();

        //-- Set Confidentiality --
        $(By.xpath(".//*[@id='targetObjectForm:prRepeat:0:category']")).selectOption(confidentiality);
        $(By.xpath(".//*[@id='targetObjectForm:prRepeat:0:reason']")).setValue(text + " for " + confidentiality + " confidentiality");


        //-- Set Integrity --
        $(By.xpath(".//*[@id='targetObjectForm:prRepeat:1:category']")).selectOption(integrity);
        $(By.xpath(".//*[@id='targetObjectForm:prRepeat:1:reason']")).setValue(text + " for " + integrity + " integrity");

        //-- Set Availability --
        $(By.xpath(".//*[@id='targetObjectForm:prRepeat:2:category']")).selectOption(availability);
        $(By.xpath(".//*[@id='targetObjectForm:prRepeat:2:reason']")).setValue(text + " for " + integrity + " availability");

        //Click save button
        $(By.xpath(".//*[@id='saveEnabled']")).waitUntil(enabled, 6000).click();

        $(By.xpath(".//*[@id='footerForm:message']/dt")).waitUntil(visible, 60000).shouldHave(text("Successfully saved"));
    }





}
