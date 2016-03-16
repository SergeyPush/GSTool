package tests.MAT_Security_Analysis;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class Test002_QuickSearch_TO extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Quick search created TO")
    public void QuickSearchOfCreatedTO() {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String TOname = "testBuilding";

        // Quick search of TO
        $(By.xpath(".//*[@id='dataListID:quickSearchField_to_dataList']")).val(TOname);
        $(By.xpath(".//*[@id='dataListID:j_id314']/img")).click();

        $(By.partialLinkText(TOname)).shouldBe(visible).shouldHave(text(TOname));
    }
}
