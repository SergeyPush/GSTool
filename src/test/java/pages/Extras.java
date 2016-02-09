package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Extras_pages.User_Administration;
import utils.BaseClass;
import utils.Property_Loader;

public class Extras extends BaseClass {

    public static User_Administration USER_ADMINISTRATION(){

//        new WebDriverWait(driver, 7).until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath(".//*[@id='toolBarForm:imgConfiguration']")));
//        driver.findElement(By.xpath(".//*[@id='toolBarForm:imgConfiguration']")).click();
//        new WebDriverWait(driver, 7).until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath(".//*[@id='naviForm:j_id159']")));
//        driver.findElement(By.xpath(".//*[@id='naviForm:j_id159']")).click();

        driver.navigate().to(Property_Loader.loadProperty("site.url") +"/userAdministration.jsf#");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User_Administration(driver);

    }

}
