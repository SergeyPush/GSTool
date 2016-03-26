package tests.MAT_Security_Analysis;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenPluses;
import utils.OpenView;

public class Test010_Delete_Created_TO extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Delete Created TO ")

    public void deleteCreatedTO() throws InterruptedException {

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


    }
}
