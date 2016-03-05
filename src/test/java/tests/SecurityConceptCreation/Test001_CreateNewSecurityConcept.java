package tests.SecurityConceptCreation;

import org.junit.Test;
import org.openqa.selenium.By;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class Test001_CreateNewSecurityConcept extends AbstractClass{


    @Test
    public void testCreateNewSecurityConcept() throws Exception {


        SelectView.OpenPage("Security Concepts");

        String conceptName = "TestConcept";

        $("#newEnabled").waitUntil(enabled, 6000).click();
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(visible, 6000);


        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String securityConceptName = conceptName + simpleDateFormat.format(date);

        $(By.xpath(".//*[@id='safetyConceptForm:newName']")).sendKeys(securityConceptName);
        $(By.xpath(".//*[@id='safetyConceptForm:newDescription']")).sendKeys("Automatically created security concept");

        $("#saveEnabled").click();


        $(By.xpath(".//*[@id='creatingNew_SCVProgressForm:successAlert']")).waitUntil(visible, 50000);
        $(By.xpath(".//*[@id='creatingNew_closeNewSCVCreation']")).waitUntil(present, 50000).click();

        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(disappear, 6000);
        $(By.xpath(".//*[@id='footerForm:currentSCV']")).waitUntil(hasText(conceptName), 10000);


    }
}
