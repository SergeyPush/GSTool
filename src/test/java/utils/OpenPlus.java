package utils;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class OpenPlus extends BaseClass {

    public static void expandAll() throws InterruptedException {

        WebDriverRunner.setWebDriver(driver);
        ElementsCollection list = $$("._a>img");


        for (SelenideElement elm : list) {
            if (elm.getAttribute("src").contains("Closed")) {
                Thread.sleep(200);
                elm.click();
                Thread.sleep(500);
            }
        }

    }

}
