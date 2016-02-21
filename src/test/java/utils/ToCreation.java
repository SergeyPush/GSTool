package utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ToCreation extends BaseClass{

    public static void CreateNewTO(String Type) throws InterruptedException {
        WebDriverRunner.setWebDriver(driver);

        $(By.xpath(".//*[@id='addElementEnabled']")).click();

        Thread.sleep(500);
        $(By.xpath(".//*[@id='menuForm:typeMenu']")).waitUntil(enabled, 4000).selectOption(Type);

        if (WebDriverRunner.getWebDriver().findElement(By.xpath(".//*[@id='menuForm:icMenu']")).isEnabled()){
            Thread.sleep(400);
            $(By.xpath(".//*[@id='menuForm:icMenu']")).selectOption(0);
        }
        $(By.xpath(".//*[@id='menuForm:yes']")).click();


        Thread.sleep(500);
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(visible, 4000);
        String ToName = "test" + RandomName.convertName(Type);
        $(By.xpath(".//*[@id='targetObjectForm:name']")).sendKeys(ToName);
        $(By.xpath(".//*[@id='targetObjectForm:abbreviation']")).sendKeys(Type.toUpperCase());


        if (driver.findElements(By.xpath(".//*[@id='targetObjectForm:subtypes']")).size()>=1){
            $(By.xpath(".//*[@id='targetObjectForm:subtypes']")).click();
            Thread.sleep(100);
            $(By.xpath(".//*[@id='subtypeSelectionForm:subtypeSelection_personTable:0:subtypeSelectionstate0_fake']")).click();
            $(By.xpath(".//*[@id='subtypeSelectionForm:subtypeSelectionokLink']")).waitUntil(enabled, 4000).click();

        }

        $(By.xpath(".//*[@id='saveEnabled']")).waitUntil(enabled, 4000).click();
        $(By.xpath(".//*[@id='footerForm:message']/dt")).waitUntil(visible, 5000);

    }

}
