package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUser extends BaseClass {

    public static void LoginProperly() {


        if (driver.findElement(By.xpath(".//*[@id='loginForm']/table/tbody/tr[1]/td/span")).isDisplayed()) {
            String name = Property_Loader.loadProperty("user.username");
            String pass = Property_Loader.loadProperty("user.password");


            driver.findElement(By.id("j_username")).sendKeys(name);
            driver.findElement(By.id("j_password")).sendKeys(pass);
            driver.findElement(By.id("j_submit")).click();
            new WebDriverWait(driver, 5).until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(".//*[@id='changeSafetyConceptPanelHeader']")));
            Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='changeSafetyConceptPanelHeader']")).isDisplayed());

            driver.findElement(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).click();

            new WebDriverWait(driver, 5).until(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")));

            driver.get(Property_Loader.loadProperty("site.url") + "/targetObject.jsf");


        }


    }
}
