package com.infopulse.gst.autotest.MAT_Security_Analysis;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Title;
import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenPluses;
import com.infopulse.gst.autotest.utils.OpenView;
import com.infopulse.gst.autotest.utils.TargetObject;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Test001_Select_Created_TO extends GSTAbstractClass{

    @Test
    @Title("Create new TO")
    public void testSelectCreatedTO() throws Exception {

        OpenView.NavigateTO(Grundschutz, InventoryAnalysis);

        String TOname = "testBuilding";
        TargetObject.CreateNew("Building", TOname, "Lawyer Agency");

        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(visible, 10000).shouldHave(text("Successfully saved")).shouldHave(text(TOname));

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);
        OpenPluses.ExpandAll();
        $(By.partialLinkText(TOname)).shouldBe(visible).shouldHave(text(TOname));

    }
}
