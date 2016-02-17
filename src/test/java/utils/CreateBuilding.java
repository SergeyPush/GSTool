package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CreateBuilding extends BaseClass{

    public static void generalBuilding(String name) throws InterruptedException {

//        driver.get(Property_Loader.loadProperty("site.url")+"/targetObject.jsf");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        Common.MAIN_MENU().clickAddButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='menuForm:typeMenu']")));

        new Select(driver.findElement(By.xpath(".//*[@id='menuForm:typeMenu']"))).selectByVisibleText("Building");
        Thread.sleep(500);
        new Select(driver.findElement(By.xpath(".//*[@id='menuForm:icMenu']"))).selectByIndex(0);
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='menuForm:yes']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")));

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");


        driver.findElement(By.xpath(".//*[@id='targetObjectForm:name']")).sendKeys(name+"_" + simpleDateFormat.format(date));
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='targetObjectForm:abbreviation']")).sendKeys(name.toUpperCase());

        Common.MAIN_MENU().clickSaveButton();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")));


    }

}
