package tests.MAT_Security_Analysis;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import utils.TargetObject;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Test001_Select_Created_TO extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Test create new user")
    public void testSelectCreatedTO() throws Exception {

        OpenView.NavigateTO(Grundschutz, InventoryAnalysis);

        String TOname = "testBuilding";

        TargetObject.CreateNew("Building", TOname, "Lawyer Agency");


        $(By.partialLinkText(TOname)).shouldBe(visible).shouldHave(text(TOname));
    }
}
