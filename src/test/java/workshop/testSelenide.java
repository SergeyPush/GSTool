package workshop;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class testSelenide extends NewAbstract {


    @Test
    public void testSelenide() throws Exception {


        $("#changeSafetyConceptPanelHeader").waitUntil(visible, 6000);
        $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).click();
        $("#changeSafetyConceptPanelHeader").waitUntil(disappear, 6000);

        $("#addElementEnabled").click();
        $(By.xpath(".//*[@id='menuForm:typeMenu']")).selectOption("Building");
        $(By.xpath(".//*[@id='menuForm:yes']")).click();


        Thread.sleep(1000);
        $(By.xpath(".//*[@id='targetObjectForm:name']")).val("Burger King");
        $(By.xpath(".//*[@id='targetObjectForm:abbreviation']")).val("BURGER KING");

        $("#saveEnabled").waitUntil(enabled, 6000).click();

        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).shouldBe(visible).shouldHave(text("Successfully saved"));

    }
}
