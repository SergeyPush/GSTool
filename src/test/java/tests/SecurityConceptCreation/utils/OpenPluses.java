package tests.SecurityConceptCreation.utils;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class OpenPluses {

    public static void ExpandAll() throws InterruptedException {

        ElementsCollection list = $$(By.xpath(".//*[@id='to_dataList_datalistScrollableContainer']//*[@class='_a']/img"));

        for (SelenideElement elm : list)
            if (elm.getAttribute("src").contains("Closed")) {
                Thread.sleep(400);
                elm.click();
                Thread.sleep(400);
            }

    }

}
