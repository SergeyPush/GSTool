package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class OpenPlus extends BaseClass {

    public static void expandAll() throws InterruptedException {

        for (int i = 0; i < 4; i++) {

            ArrayList<WebElement> list1 = new ArrayList<WebElement>($$("._a>img"));
            for (WebElement elm : list1) {
                if (elm.getAttribute("src").contains("Closed")) {
                    Thread.sleep(500);

                    elm.click();

                }
            }
        }
    }


}
