package pages.Common_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenu {

    WebDriver driver;

    public MainMenu(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='addElementEnabled']")
    WebElement addButton;

    @FindBy(xpath = ".//*[@id='saveEnabled']")
    WebElement saveButton;

    @FindBy(xpath = ".//*[@id='deleteElementEnabled']")
    WebElement deleteButton;

    public void clickSaveButton() throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='saveEnabled']")));
        saveButton.click();
        Thread.sleep(1000);
    }

    public void clickAddButton() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addElementEnabled']")));
        Thread.sleep(500);
        addButton.click();
        Thread.sleep(500);
    }


    public void clickDeleteButton() throws InterruptedException {
        deleteButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='genericConfirmPanelYes']")));
        driver.findElement(By.xpath(".//*[@id='genericConfirmPanelYes']")).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='footerForm:message']/dt")));
        Thread.sleep(1000);
    }
}
