package pages.Extras_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.OpenPlus;

public class Security_anays_pages {

    WebDriver driver;
    public Security_anays_pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='dataListID:quickSearchField_to_dataList']")
    WebElement quickSearchField;


    public void SelectCreatedTO(String tOname) throws InterruptedException {
        OpenPlus.expandAll();
        Thread.sleep(500);
        driver.findElement(By.partialLinkText(tOname)).click();
        Thread.sleep(500);
    }

    public void quickSearchTO(String tOname) throws InterruptedException {
        quickSearchField.sendKeys(tOname);
        driver.findElement(By.xpath(".//*[@id='dataListID:j_id314']/img")).click();
        Thread.sleep(500);

    }
}
