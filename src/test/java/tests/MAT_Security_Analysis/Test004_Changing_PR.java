package tests.MAT_Security_Analysis;


import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.SA_PR;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test004_Changing_PR extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Change Protection Requirements for selected TO")
    public void testChangingPR() throws InterruptedException {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        //Select TO
        String TOname = "testBuilding";
        String Description = "This is test description";

        $(By.partialLinkText(TOname)).click();

        //Open SA_PR tab change requirements
        SA_PR.setPRforTO(normal, high, veryHigh, Description);


        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 8000).shouldHave(text("Successfully saved")).shouldHave(text(TOname));


    }
}
