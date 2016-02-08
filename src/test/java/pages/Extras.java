package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Extras_pages.User_Administration;
import utils.BaseClass;

public class Extras extends BaseClass {

    public static User_Administration USER_ADMINISTRATION(){

//        new WebDriverWait(driver, 7).until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath(".//*[@id='toolBarForm:imgConfiguration']")));
//        driver.findElement(By.xpath(".//*[@id='toolBarForm:imgConfiguration']")).click();
//        new WebDriverWait(driver, 7).until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath(".//*[@id='naviForm:j_id159']")));
//        driver.findElement(By.xpath(".//*[@id='naviForm:j_id159']")).click();

        driver.navigate().to("http://10.211.55.3:9090/gst2015/gstool/userAdministration.jsf#");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User_Administration(driver);

    }

}
