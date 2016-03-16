package tests.SecurityConceptCreation.utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class CreateNew {


    public static void CreateTO(String type, String name, String linkToAsset) throws InterruptedException {

        if ($(By.xpath(".//*[@id='genericConfirmPanelNo']")).isDisplayed()) {
            $(By.xpath(".//*[@id='genericConfirmPanelNo']")).click();
        }
        //Click plus button
        $(By.xpath(".//*[@id='addElementEnabled']")).waitUntil(enabled, 30000).click();

        //Select type of Asset
        $(By.xpath(".//*[@id='menuForm:typeMenu']")).waitUntil(enabled, 10000).selectOption(type);

        Thread.sleep(1000);
        //Link to Asset
        if ($(By.xpath(".//*[@id='menuForm:icMenu']")).exists()) {
            $(By.xpath(".//*[@id='menuForm:icMenu']")).selectOption(linkToAsset);
        }
        //Click Ok button
        $(By.xpath(".//*[@id='menuForm:yes']")).click();

        $("#newObjectPanelHeader").waitUntil(disappear, 8000);
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(enabled, 8000);

        //Enter name of TO
        Thread.sleep(1000);
        $(By.xpath(".//*[@id='targetObjectForm:name']")).waitUntil(present, 6000).val(name);


        //Enter tocken
        Thread.sleep(1000);
        $(By.xpath(".//*[@id='targetObjectForm:abbreviation']")).sendKeys(type.toUpperCase());

        //Select Subtype
        if ($(By.xpath(".//*[@id='targetObjectForm:subtypes']")).exists()) {
            $(By.xpath(".//*[@id='targetObjectForm:subtypes']")).click();

            $(By.xpath(".//*[@id='subtypeSelectionForm:subtypeSelection_personTable:0:subtypeSelectionstate0_fake']")).click();
            $(By.xpath(".//*[@id='subtypeSelectionForm:subtypeSelectionokLink']")).waitUntil(enabled, 6000).click();
        }

        //Click save button
        $(By.xpath(".//*[@id='saveEnabled']")).waitUntil(enabled, 6000).click();


        $(By.xpath(".//*[@id='footerForm:message']/dt")).waitUntil(visible, 60000).shouldHave(text("Successfully saved"));


    }
}
