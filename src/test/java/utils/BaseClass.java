package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
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
    public static void tearDown() throws InterruptedException {
        Thread.sleep(500);

        try{
            driver.findElement(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")).click();
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }

}
