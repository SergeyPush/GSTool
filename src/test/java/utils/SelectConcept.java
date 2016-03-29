package utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelectConcept {

    public static void selectDefaultConcept(){

//        $("#closeChangeSafetyConcept").waitUntil(enabled, 10000).click();
        if ($("#changeSafetyConceptPanelHeader").isDisplayed()){
            $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).waitUntil(enabled, 10000).click();
            $("#changeSafetyConceptPanelHeader").waitUntil(disappear, 8000);
        }


    }

    public static void selectConcept(String conceptName){
        $(By.xpath(".//*[@id='changeSafetyConceptForm:safetyConceptGroupMenu']")).selectOption(conceptName);
        $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).waitUntil(visible, 10000).click();
    }
}
