package pages.Extras_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Role_administration {
    WebDriver driver;

    public Role_administration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='addElementEnabled']")
    WebElement newRoleButton;

    @FindBy(xpath = ".//*[@id='roleAdministrationForm:name']")
    WebElement nameField;

    @FindBy(xpath = ".//*[@id='saveEnabled']")
    WebElement saveButton;

    @FindBy(xpath = ".//*[@id='deleteElementEnabled']")
    WebElement deleteButton;

    @FindBy(id = "discardEnabled")
    WebElement cancelButton;

    @FindBy(xpath = ".//*[@id='permissionAreaDataListForm:j_id640']//*[@class='_cell']/a")
    WebElement getGlobalAreaLink;


    public void CreateNewRole(String roleName) {

        newRoleButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(".//*[@id='div_change_event']")));

        nameField.sendKeys(roleName);
        saveButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(By.xpath(".//*[@id='deleteElementEnabled']")));
    }

    public void EditDescription(String description) throws InterruptedException {
        driver.findElement(By.partialLinkText("testrole")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='roleAdministrationForm:description']"))
                .sendKeys(description);
        Thread.sleep(500);
        cancelButton.click();
    }

    public void DeleteCreatedRole() throws InterruptedException {
        driver.findElement(By.partialLinkText("testrole")).click();

        Thread.sleep(500);
        deleteButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(".//*[@id='confirmationDialog-confirm']")));

        driver.findElement(By.xpath(".//*[@id='confirmationDialog-confirm']")).click();
    }

    public void SelectRole(String testrole) throws InterruptedException {
        driver.findElement(By.partialLinkText(testrole)).click();
    }

    public void selectGlobal() {
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(".//*[@id='1']/table/tbody/tr/td[4]/a")));
        getGlobalAreaLink.click();

    }

    public void CheckAllPermissions() throws InterruptedException {

        driver.findElement(By.xpath(".//*[@id='roleAdministrationForm:tabModules_lbl']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(".//*[@id='1']/table/tbody/tr/td[6]/div/input")));


        driver.findElement(By.xpath(".//*[@id='1']/table/tbody/tr/td[6]/div/input")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath(".//*[@id='1']/table/tbody/tr/td[7]/div/input")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath(".//*[@id='1']/table/tbody/tr/td[8]/div/input")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath(".//*[@id='1']/table/tbody/tr/td[9]/div/input")).click();
        Thread.sleep(400);

    }
}
