package tests.SecurityConceptCreation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Try extends AbstractClass {

    @Test
    public void testName() throws Exception {

        SelectView.OpenPage(Grundschutz, Security_Check);
//        OpenPluses.ExpandAll();
        $(By.partialLinkText("Lawyer Agency")).waitUntil(present, 8000).click();
        $(By.partialLinkText("Anforderungsmanagement")).waitUntil(visible, 8000).click();

        $(By.xpath(".//*[@id='securityCheckForm:tabModuleAdditionalControl_lbl']")).click();
        ElementsCollection l = $$(By.xpath(".//*[@id='securityCheckForm:taskRealization_additionalControlForMe']//div/select"));
        for (SelenideElement element:l){
            Thread.sleep(300);
            element.selectOption("No");
            Thread.sleep(300);
        }

        $("#saveEnabled").click();
        $(By.xpath(".//*[@id='footerForm:message']/dt")).waitUntil(visible, 6000).shouldHave(text("Successfully saved"));

    }

    @After
    public void tearDown() throws Exception {
        if ($(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).isDisplayed()) {
            $(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).click();
        }

    }
}
