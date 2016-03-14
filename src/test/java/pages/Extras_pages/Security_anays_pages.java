package pages.Extras_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Common;
import utils.OpenPlus;

public class Security_anays_pages {

    WebDriver driver;

    public Security_anays_pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='dataListID:quickSearchField_to_dataList']")
    WebElement quickSearchField;

    @FindBy(xpath = ".//*[@id='securityAnalysisForm:necessity']")
    WebElement NecessityOfRAdropdown;

    @FindBy(xpath = ".//*[@id='securityAnalysisForm:decisionUser']")
    WebElement DeciderDropdown;

    @FindBy(xpath = ".//*[@id='securityAnalysisForm:decisionDateInputDate']")
    WebElement DateOfDecisionInput;

    @FindBy(xpath = ".//*[@id='securityAnalysisForm:necessityReason']")
    WebElement ExplanationTextarea;

    @FindBy(xpath = ".//*[@id='securityAnalysisForm:prRepeat:0:category']")
    WebElement ConfidentialityDropdown;

    @FindBy(xpath = ".//*[@id='securityAnalysisForm:prRepeat:1:category']")
    WebElement IntegrityDropdown;

    @FindBy(xpath = ".//*[@id='securityAnalysisForm:prRepeat:2:category']")
    WebElement AvailabilityDropdown;

    @FindBy(xpath = ".//*[@id='dataListID:filter_to_dataList_filter_management']/tbody/tr/td[1]/select")
    WebElement selectFilterDropdown;



    public void SelectCreatedTO(String tOname) throws InterruptedException {
        OpenPlus.expandAll();
        Thread.sleep(500);
        driver.findElement(By.partialLinkText(tOname)).click();
        Thread.sleep(500);
    }

    public void quickSearchTO(String tOname) throws InterruptedException {
        quickSearchField.sendKeys(tOname);
        driver.findElement(By.xpath(".//*[@id='dataListID:j_id314']/img")).click();
        Thread.sleep(500);

    }

    public void ChangeNecessity(String necessityOfRA, String decider, String dateOfDecision, String explanation) throws InterruptedException {
        Thread.sleep(500);
        new Select(NecessityOfRAdropdown).selectByVisibleText(necessityOfRA);
        Thread.sleep(500);
        new Select(DeciderDropdown).selectByIndex(Integer.parseInt(decider));
        Thread.sleep(500);
        DateOfDecisionInput.sendKeys(dateOfDecision);
        Thread.sleep(500);
        ExplanationTextarea.sendKeys(explanation);

        Common.MAIN_MENU().clickSaveButton();

        new WebDriverWait(driver, 5).until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")));
    }

    public void SetProtectionRequirement(String confidentiality, String integrity, String availability, String description) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='securityAnalysisForm:protectionRequirementTab_lbl']")).click();
        Thread.sleep(500);

        new Select(ConfidentialityDropdown).selectByVisibleText(confidentiality);
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:0:reason']")).clear();
        driver.findElement(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:0:reason']")).sendKeys(description);
        Thread.sleep(500);

        new Select(IntegrityDropdown).selectByVisibleText(integrity);
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:1:reason']")).clear();
        driver.findElement(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:1:reason']")).sendKeys(description);
        Thread.sleep(500);

        new Select(AvailabilityDropdown).selectByVisibleText(availability);
        Thread.sleep(500);
        driver.findElement(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:2:reason']")).clear();
        driver.findElement(By.xpath(".//*[@id='securityAnalysisForm:prRepeat:2:reason']")).sendKeys(description);
        Thread.sleep(500);

    }

    public void SelectPredefinedFilter(String filterName) {
        new Select(selectFilterDropdown).selectByVisibleText(filterName);
    }

    public void creaateNewFilter(String filterName, String tOsubtype, String tOtype) throws InterruptedException {

        driver.findElement(By.xpath(".//*[@id='dataListID:j_id279']/img")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:name']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:name']")).sendKeys(filterName);
        Thread.sleep(500);
        new Select(driver.findElement(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:conditionGroup:0:basicConditionFacade:0:basicConditionValueDropDawn']")))
                .selectByVisibleText(tOsubtype);
        Thread.sleep(500);
        new Select(driver.findElement(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:conditionGroup:0:basicConditionFacade:4:basicConditionValueDropDawn']")))
                .selectByVisibleText(tOtype);
        Thread.sleep(1000);

        driver.findElement(By.xpath(".//*[@id='securityAnalysisFilterPanel_dataListFilterForm:commandExecute']")).click();

    }
}
