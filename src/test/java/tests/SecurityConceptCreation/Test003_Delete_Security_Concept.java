package tests.SecurityConceptCreation;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import tests.SecurityConceptCreation.utils.AbstractClass;
import utils.OpenPluses;
import utils.OpenView;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Test003_Delete_Security_Concept extends AbstractClass{

    @Test
    @Title("Delete created concept")
    public void testDeleteCreatedConcept() throws Exception {

        OpenView.NavigateTO("Security Concepts");

        String conceptName = "TestConcept";
        String version = "//a[contains(text(), 'Version 1')]";

        Thread.sleep(1000);

        ElementsCollection list = $$("._a>img");

        for (SelenideElement elm : list) {

            if (elm.getAttribute("src").contains("Closed")) {
                Thread.sleep(200);
                elm.click();
                Thread.sleep(100);
            }
        }
        //Activate multiselect
        $(By.xpath(".//*[@id='safetyConceptListForm:j_id405']/img")).setSelected(true);

        //Check checkbox

        $(By.xpath("//a[contains(text(), '"+conceptName+"')]/../../td[@class='checkbox']/input")).setSelected(true);

        //Deactivate
        $("#inactiveEnabled").waitUntil(enabled, 8000).click();

        //Confirm Deactivation
        $("#genericConfirmPanelYes").waitUntil(enabled, 8000).click();

        //Assert
        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 10000).shouldHave(text("Objects deactivated successfully"));

        //Delete
        $("#deleteElementEnabled").waitUntil(enabled, 8000).click();

        // Confirm Delete
        $("#genericConfirmPanelYes").waitUntil(enabled, 8000).click();

        //Close Activity Window
        $(By.xpath(".//*[@id='deleteSCV_TaskProgressForm:successAlert']")).waitUntil(visible, 20000).shouldHave(text("Operation completed"));
        $(By.xpath(".//*[@id='deleteSCV_closeProgressEnabled']")).waitUntil(enabled, 10000).click();

    }
}
