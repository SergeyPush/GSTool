package tests.SecurityConceptCreation;

import com.codeborne.selenide.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import utils.Property_Loader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AbstractClass {

    @BeforeClass
    public static void setUpClass() throws Exception {

        String URL = Property_Loader.loadProperty("site.url") + "/targetObject.jsf";
//        Configuration.browser = "chrome";
        open(URL);

        if ($(By.xpath(".//*[@id='loginForm']/table")).isDisplayed()) {
            LoginPage.LoginProperly();
            SelectConcept.selectDefaultConcept();
        }


    }

    @AfterClass
    public static void tearDownClass() {

    }
}
