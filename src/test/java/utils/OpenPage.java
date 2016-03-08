package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenPage extends BaseClass {


    public static void selectTab (String section, String view) throws InterruptedException {

        Thread.sleep(500);

        new Select(driver.findElement(By.xpath(".//*[@id='naviForm:tabConfiguration']")))
                .selectByVisibleText(section);

        String view2 = "//a[contains(text(), '" + view + "')]";


        Thread.sleep(1000);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(view2)));
        driver.findElement(By.xpath(view2)).click();
    }
}
