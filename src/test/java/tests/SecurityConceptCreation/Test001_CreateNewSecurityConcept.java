package tests.SecurityConceptCreation;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Property_Loader;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class Test001_CreateNewSecurityConcept extends AbstractClass{


    @Test
    public void testCreateNewSecurityConcept() throws Exception {

        String SecurityConceptPage = Property_Loader.loadProperty("site.url")+"/securityConcepts.jsf";
        open(SecurityConceptPage);


        $("#newEnabled").waitUntil(enabled, 6000).click();
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(visible, 6000);


        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String SecurityConceptName = "TestConcept_" + simpleDateFormat.format(date);


        $(By.xpath(".//*[@id='safetyConceptForm:newName']")).sendKeys(SecurityConceptName);
        $(By.xpath(".//*[@id='safetyConceptForm:newDescription']")).sendKeys("Automatically created security concept");


        $("#saveEnabled").click();


        $(By.xpath(".//*[@id='creatingNew_closeNewSCVCreation']")).waitUntil(visible, 30000).click();
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(disappear, 6000);


    }
}
