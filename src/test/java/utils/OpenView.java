package utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Selenide.$;

public class OpenView {

    public static void NavigateTO(String page) {

        $(By.xpath(".//*[@id='topNaviForm:topNaviSelect']")).selectOption(page);
    }

    public static void NavigateTO(String page, String tab) {

        $(By.xpath(".//*[@id='topNaviForm:topNaviSelect']")).selectOption(page);

        $(By.xpath("//a[contains(text(), '" + tab + "')]")).waitUntil(visible, 6000).click();

        $(By.xpath("//a[contains(text(), '" + tab + "')]")).waitUntil(enabled, 30000);

        if (tab.equals("Risk Analysis")) {
            $("#resetThreatEvaluationEnabled").waitUntil(present, 60000);
        }

    }

    public static void openExtras(String tab) {

        $(By.xpath(".//*[@id='toolBarForm:imgConfiguration']")).click();

        $(By.xpath("//a[contains(text(), '" + tab + "')]")).waitUntil(enabled, 6000).click();
    }
}
