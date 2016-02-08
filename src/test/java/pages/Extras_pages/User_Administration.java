package pages.Extras_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class User_Administration {

    WebDriver driver;
    public User_Administration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = ".//*[@id='addElementEnabled']")
    WebElement newButton;

    @FindBy(id = "userAdministrationForm:account")
    WebElement UserNameField;

    @FindBy(xpath = ".//*[@id='userAdministrationForm:isChangePassword']")
    WebElement PasswordMustBeChangedCheckbox;

    @FindBy(xpath = ".//*[@id='userAdministrationForm:newPassword']")
    WebElement PasswordField;

    @FindBy(xpath = ".//*[@id='userAdministrationForm:repeatPassword']")
    WebElement RepeatPasswordField;

    @FindBy(xpath = ".//*[@id='saveEnabled']")
    WebElement saveButton;

    @FindBy(id = "userAdministrationForm:changePassword")
    WebElement editButton;

    @FindBy(xpath = ".//*[@id='discardEnabled']")
    WebElement cancelButton;

    @FindBy(xpath = ".//*[@id='deleteElementEnabled']")
    WebElement deleteButton;

    @FindBy(xpath = ".//*[@id='confirmationDialog-confirm']")
    WebElement confirmDeleteButton;


    public void addNewUser(String name, String pass){

        newButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")));
        UserNameField.sendKeys(name);
        PasswordMustBeChangedCheckbox.click();
        PasswordField.sendKeys(pass);
        RepeatPasswordField.sendKeys(pass);
        saveButton.click();
    }

    public  void editUserPassword(String name, String password){
        driver.findElement(By.partialLinkText(name)).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        editButton.click();
        PasswordField.clear();
        PasswordField.sendKeys(password);
        RepeatPasswordField.clear();
        RepeatPasswordField.sendKeys(password);
        cancelButton.click();
    }

    public  void deleteUser(String name) {
        driver.findElement(By.partialLinkText(name)).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deleteButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(".//*[@id='confirmationDialog-confirm']")));
        confirmDeleteButton.click();
        new WebDriverWait(driver, 2).until(ExpectedConditions
                .invisibilityOfElementLocated(By.partialLinkText(name)));

    }

}
