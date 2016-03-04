package tests.SecurityConceptCreation;

import com.codeborne.selenide.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import utils.Property_Loader;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AbstractClass {

    @BeforeClass
    public static void setUpClass() throws Exception {

        String URL = Property_Loader.loadProperty("site.url")+"/targetObject.jsf";
        String Username = Property_Loader.loadProperty("user.username");
        String Password = Property_Loader.loadProperty("user.password");

        Configuration.browser = "chrome";
        open(URL);
        $("#j_username").sendKeys(Username);
        $("#j_password").sendKeys(Password);
        $("#j_submit").click();

        $(By.xpath(".//*[@id='changeSafetyConceptForm:safetyConceptGroupMenu']")).selectOption(1);
        $(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).waitUntil(visible, 10000).click();
    }

    @AfterClass
    public static void tearDownClass(){

        System.out.println("Test is finished");

    }
}
