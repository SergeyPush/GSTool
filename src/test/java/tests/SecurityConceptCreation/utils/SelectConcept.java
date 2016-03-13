package tests.SecurityConceptCreation.utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelectConcept {

    public static void selectDefaultConcept(){
        $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).waitUntil(visible, 10000).click();
    }

    public static void selectConcept(String conceptName){
        $(By.xpath(".//*[@id='changeSafetyConceptForm:safetyConceptGroupMenu']")).selectOption(conceptName);
        $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).waitUntil(visible, 10000).click();
    }
}
