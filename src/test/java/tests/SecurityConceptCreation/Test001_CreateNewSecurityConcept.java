package tests.SecurityConceptCreation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import utils.GSTAbstractClass;
import utils.OpenView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Test001_CreateNewSecurityConcept extends GSTAbstractClass {


    @Test
    @Title("Create new security concept")
    public void test001CreateNewSecurityConcept() throws Exception {


        OpenView.NavigateTO("Security Concepts");

        String conceptName = "TestConcept";

        //Click NEW
        $("#newEnabled").waitUntil(enabled, 6000).click();
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(visible, 6000);

        //Ged data and time for Security Concept
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String securityConceptName = conceptName + simpleDateFormat.format(date);

        //Enter name and description of SC
        $(By.xpath(".//*[@id='safetyConceptForm:newName']")).sendKeys(securityConceptName);
        $(By.xpath(".//*[@id='safetyConceptForm:newDescription']")).sendKeys("Automatically created security concept");

        //Click Save button
        $("#saveEnabled").click();

        //Close SC window
        $(By.xpath(".//*[@id='creatingNew_SCVProgressForm:successAlert']")).waitUntil(visible, 50000);
        $(By.xpath(".//*[@id='creatingNew_closeNewSCVCreation']")).waitUntil(present, 50000).click();

        //Asserts
        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(disappear, 6000);
        $(By.xpath(".//*[@id='footerForm:currentSCV']")).waitUntil(hasText(conceptName), 10000);

        $(By.partialLinkText(conceptName)).click();
    }

    @Test
    @Title("Check option Ask for linking")
    public void test002EnableLinkTOs() throws Exception {
        //Open Settings
        $(By.xpath(".//*[@id='toolBarForm:imgConfiguration']")).waitUntil(enabled, 6000).click();

        //Click Base options1
        $(By.xpath(".//*[@id='1']/table/tbody/tr/td[4]/a")).click();
        $(By.xpath(".//*[@id='baseOptionsForm:tabBasicGroup3_lbl']")).click();

        //Link TO Automatically
        $(By.xpath(".//*[@id='baseOptionsForm:category:1:j_id735_body']/table/tbody/tr[1]/td[2]/select")).selectOption("Ask");
        $(By.xpath(".//*[@id='saveEnabled']")).waitUntil(enabled, 6000).click();
        $(By.xpath(".//*[@id='footerForm:message']/dt")).waitUntil(visible, 8000).shouldHave(text("Successfully saved"));
    }
}
