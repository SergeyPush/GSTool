package com.infopulse.gst.autotest.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class OpenPluses extends GSTAbstractClass {

    public static void ExpandAll() throws InterruptedException {
        Thread.sleep(1000);

        ElementsCollection list = $$("#to_dataList_datalistScrollableContainer ._a>img");

        for (SelenideElement elm : list) {

            if (elm.getAttribute("src").contains("Closed")) {
                Thread.sleep(200);
                elm.waitUntil(enabled, 4000).click();
                Thread.sleep(200);
            }
        }
    }
}