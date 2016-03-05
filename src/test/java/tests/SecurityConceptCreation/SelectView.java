package tests.SecurityConceptCreation;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelectView {

    public static void OpenPage(String page){

        $(By.xpath(".//*[@id='topNaviForm:topNaviSelect']")).selectOption(page);
    }

    public static void OpenPage(String page, String tab){

        $(By.xpath(".//*[@id='topNaviForm:topNaviSelect']")).selectOption(page);

        $(By.xpath(".//*[@id='naviForm:targetObjectTabId']")).waitUntil(visible, 6000).click();


    }
}
