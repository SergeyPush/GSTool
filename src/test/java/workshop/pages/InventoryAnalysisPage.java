package workshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryAnalysisPage {
    WebDriver driver;

    public InventoryAnalysisPage(WebDriver driver) {
        this.driver = driver;
    }


    public void createNewBuilding(String name, String token) throws InterruptedException {

        // Create building
        driver.findElement(By.xpath(".//*[@id='addElementEnabled']")).click();
        Thread.sleep(1000);
        new Select(driver.findElement(By.xpath(".//*[@id='menuForm:typeMenu']"))).selectByVisibleText("Building");
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='menuForm:yes']")).click();

        driver.findElement(By.xpath(".//*[@id='targetObjectForm:name']")).sendKeys(name);
        driver.findElement(By.xpath(".//*[@id='targetObjectForm:abbreviation']")).sendKeys(token);

        // Click Save button
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='saveEnabled']")));
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='saveEnabled']")).click();
    }
}
