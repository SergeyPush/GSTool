package tests.MAT_Security_Analysis;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Test005_Applying_Predefined_Filter extends GSTAbstractClass{

    @Features("Security Analysis")
    @Test
    @Title("Applying Predefined Filter")

    public void testApplyPredefinedFilter() {

        OpenView.NavigateTO(Grundschutz, SecurityAnalysis);

        String FilterName = "Risk analysis required";
        String TOname = "testBuilding";

        //Applying filter 'Risk analysis required'
        $(By.xpath(".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[1]/select")).waitUntil(enabled, 8000).selectOption(FilterName);

        //Assert
        $(By.partialLinkText(TOname)).shouldBe(visible, enabled);

    }
}
