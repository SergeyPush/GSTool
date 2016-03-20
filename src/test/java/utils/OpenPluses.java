package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class OpenPluses extends GSTAbstractClass {

    public static void ExpandAll() throws InterruptedException {
        Thread.sleep(1000);

        ElementsCollection list = $$("#to_dataList_datalistScrollableContainer ._a>img");

        for (SelenideElement elm : list) {

            if (elm.getAttribute("src").contains("Closed")) {
                Thread.sleep(200);
                elm.click();
                Thread.sleep(100);
            }
        }
    }
}