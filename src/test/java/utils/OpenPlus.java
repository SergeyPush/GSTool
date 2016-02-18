package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class OpenPlus extends BaseClass {

    public static void expandAll() throws InterruptedException {

        WebDriverRunner.setWebDriver(driver);
        ElementsCollection list = $$("._a>img");


        for (SelenideElement elm : list) {
            if (elm.getAttribute("src").contains("Closed")) {
                elm.click();
                Thread.sleep(500);
            }
        }

    }
}
