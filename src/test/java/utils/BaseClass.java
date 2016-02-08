package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected static WebDriver driver;
    public static String browser;

    @BeforeClass
    public static void setUp() {

        browser = Property_Loader.loadProperty("browser.name");
        if (browser.equals("chrome")) {

            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Property_Loader.loadProperty("site.url"));

    }


    @AfterClass
    public static void tearDown() {
        driver.quit();


    }
}
