package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Extras_pages.Security_anays_pages;
import utils.BaseClass;
import utils.Property_Loader;

public class GrundSchutz extends BaseClass{

    public static Security_anays_pages SECURITY_ANALYSIS(){

        driver.navigate().to(Property_Loader.loadProperty("site.url") +"/securityAnalysis.jsf");

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(".//*[@id='securityAnalysisForm:securityAnalysingTab_lbl']")));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Security_anays_pages(driver);

    }



}
