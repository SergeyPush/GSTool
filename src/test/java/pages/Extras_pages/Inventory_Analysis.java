package pages.Extras_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;
import utils.OpenPlus;

public class Inventory_Analysis extends BaseClass{

WebDriver driver;

    public Inventory_Analysis(WebDriver driver) {
        this.driver = driver;
    }

    public void SelectToName(String tOname) throws InterruptedException {
        OpenPlus.expandAll();
        Thread.sleep(500);
        driver.findElement(By.partialLinkText(tOname)).click();
        Thread.sleep(500);
    }
}
