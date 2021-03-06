package com.infopulse.gst.autotest.MAT_Security_Analysis;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenView;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Test012_Delete_Created_TO extends GSTAbstractClass{

    @Test
    @Title("Delete Created TO ")
    public void testDeleteCreatedTO() throws InterruptedException {

        OpenView.NavigateTO(Grundschutz, InventoryAnalysis);
//        OpenPluses.ExpandAll();

        String TOname = "testBuilding";

        //Select TO
        $(By.partialLinkText(TOname)).click();

        //Click Delete Button
        $("#deleteElementEnabled").click();
        $("#genericConfirmPanelYes").waitUntil(enabled, 6000).click();

        //Assertions
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 15000).shouldBe(visible).shouldHave(text("Item successfully deleted")).shouldHave(text(TOname));
        $(By.partialLinkText(TOname)).shouldNotBe(visible, enabled);

        //TODO Create another building for risk analysis MAT with name 'building'

    }
}
