package pages.Extras_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.OpenPlus;

public class Security_anays_pages {

    WebDriver driver;

    public Security_anays_pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void SelectCreatedTO(String tOname) throws InterruptedException {
        OpenPlus.expandAll();
        driver.findElement(By.partialLinkText(tOname)).click();
    }
}
