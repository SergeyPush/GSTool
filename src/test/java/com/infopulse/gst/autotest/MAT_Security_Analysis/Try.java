package com.infopulse.gst.autotest.MAT_Security_Analysis;

import com.infopulse.gst.autotest.utils.GSTAbstractClass;
import com.infopulse.gst.autotest.utils.OpenPluses;
import com.infopulse.gst.autotest.utils.OpenView;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Try extends GSTAbstractClass{

    @Test
    public void testName() throws Exception {

        OpenView.NavigateTO(Grundschutz, SecurityCheck);
        $("#moduleEnabled").waitUntil(enabled, 8000);

        OpenPluses.ExpandAll();

        $(By.partialLinkText("Main room")).click();

        String grayBubble = $("#modules_datalistScrollableContainer .icon>img:nth-of-type(2)").getAttribute("src");
        System.out.println(grayBubble);
        $("#modules_datalistScrollableContainer .icon>img:nth-of-type(2)").shouldHave(attribute("title", "Implementation = \"Open\" completed seal level = none"));
        $("#modules_datalistScrollableContainer .icon>img:nth-of-type(2)").shouldHave(attribute("src", "http://localhost:9090/gst2016/images/evaluation/state/raw.png"));

        // $("#modules_datalistScrollableContainer .icon>img:nth-of-type(2)").shouldHave(attribute("title", "necessary from = \"Not necessary\" completed seal level = none"));
    }
}
