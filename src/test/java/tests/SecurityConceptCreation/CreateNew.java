package tests.SecurityConceptCreation;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class CreateNew {


    public static void CreateTO(String type, String name, String subtype) throws InterruptedException {

        $(By.xpath(".//*[@id='addElementEnabled']")).waitUntil(enabled, 30000).click();

        $(By.xpath(".//*[@id='menuForm:typeMenu']")).waitUntil(enabled, 10000).selectOption(type);

        if ($(By.xpath(".//*[@id='menuForm:icMenu']")).exists()){
            $(By.xpath(".//*[@id='menuForm:icMenu']")).selectOption(0);
        }
        $(By.xpath(".//*[@id='menuForm:yes']")).click();

        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(enabled, 4000);
        Thread.sleep(500);
        $(By.xpath(".//*[@id='targetObjectForm:name']")).waitUntil(enabled, 6000).val(name);

        Thread.sleep(500);
        $(By.xpath(".//*[@id='targetObjectForm:abbreviation']")).sendKeys(type.toUpperCase());


        if ($(By.xpath(".//*[@id='targetObjectForm:subtypes']")).exists()){
            $(By.xpath(".//*[@id='targetObjectForm:subtypes']")).click();

            $(By.xpath(".//*[@id='subtypeSelectionForm:subtypeSelection_personTable:0:subtypeSelectionstate0_fake']")).click();
            $(By.xpath(".//*[@id='subtypeSelectionForm:subtypeSelectionokLink']")).waitUntil(enabled, 4000).click();
        }

        $(By.xpath(".//*[@id='saveEnabled']")).waitUntil(enabled, 6000).click();

        $(By.xpath(".//*[@id='footerForm:message']/dt")).waitUntil(visible, 60000).shouldHave(text("Successfully saved"));


    }
}
