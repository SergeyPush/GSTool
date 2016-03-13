package workshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "j_username")
    WebElement loginField;

    @FindBy(id = "j_password")
    WebElement passwordField;

    @FindBy(id = "j_submit")
    WebElement submitButton;




    public void loginWithCredentials(String name, String password) {

        // Enter Credentials
        loginField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public InventoryAnalysisPage selectDefaultConcept() throws InterruptedException {

        // Select default concept
        Thread.sleep(500);
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(".//*[@id='changeSafetyConceptPanelHeader']")));

        driver.findElement(By.xpath(".//*[@id='changeSafetyConceptForm:yes']")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath(".//*[@id='changeSafetyConceptPanelHeader']")));

        return new InventoryAnalysisPage(driver);

    }
}
