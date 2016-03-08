package pages.Common_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TopMenu {

    WebDriver driver;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='toolBarForm:imgUserLogout']")
    WebElement logoutButton;


    public void LogOut() {
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(By.xpath(".//*[@id='toolBarForm:imgUserLogout']")));
        logoutButton.click();
    }
}
