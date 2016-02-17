package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.BaseClass;
import utils.LoginUser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



import java.io.File;

public class ImportSC extends BaseClass {

    @Test
    public void Name() throws Exception {
        WebDriverRunner.setWebDriver(driver);
        LoginUser.LoginProperly();
        driver.navigate().to("http://10.211.55.3:9090/gst2016/gstool/securityConcepts.jsf");
        Thread.sleep(500);

        driver.findElement(By.xpath(".//*[@id='uploadNewMetaDataEnabled']")).click();

        File file = new File("/Users/sergey/Downloads/2014_11_Metadaten_EL14.zip");

        $(By.xpath(".//*[@id='importMDForm:upload:file']")).uploadFile(file);

        Thread.sleep(3000);


//        driver.findElement(By.xpath(".//*[@id='importMDForm:upload:add2']")).click();
//        driver.findElement(By.id("importMDForm:upload:file")).sendKeys("D:\\Releases\\1\\04.Metadata\\2014_11_Metadaten_EL14");
//        Thread.sleep(1000);
//        driver.findElement(By.name("importMDForm:upload:file")).click();
//        driver.findElement(By.xpath(".//*[@id='importMDForm:closeEnabled']")).click();

    }
}
