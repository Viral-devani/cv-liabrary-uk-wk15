package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

public class Homepage extends Utility {
    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "keywords")
    WebElement jobTitle;


    @FindBy(id = "location")
    WebElement location;

    @CacheLookup
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDroppdown;

    @CacheLookup
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOption;

    @FindBy(id = "salarymin")
    WebElement salaryMin;

    @FindBy(id = "salarymax")
    WebElement salaryMax;
    @FindBy(xpath = "(//select[@id='salarytype'])[1]")
    WebElement salaryTypeDropDown;

    @FindBy(xpath = "(//select[@id='tempperm'])[1]")
    WebElement jobTypeDropDown;

    @FindBy(id = "hp-search-btn")
    WebElement findJobsBtn;

    @CacheLookup
    @FindBy(id = "gdpr-consent-notice")
    WebElement iframe;

    @CacheLookup
    @FindBy(xpath = "//span//div//span[normalize-space()='Accept All']")
    WebElement acceptCookies;

    public void enterJobTitle(String jobTitles) {
        Reporter.log("Entering Job Title " + jobTitle.toString());
        sendTextToElement(jobTitle, jobTitles);

    }

    public void enterLocation(String locations) {
        Reporter.log("Entering Location " + location.toString());
        sendTextToElement(location, locations);

    }

    public void selectDistance(String distance) {
        Reporter.log("Selecting Distance " + distanceDroppdown.toString());
        selectByVisibleTextFromDropDown(distanceDroppdown, distance);


    }

    public void clickOnMoreSearchOptionLink() {
        Reporter.log("Clicking on more search Option Link " + moreSearchOption.toString());
        clickOnElement(moreSearchOption);

    }

    public void enterMinSalary(String minSalary) {
        Reporter.log("Entering Minimum Salary " + salaryMin.toString());
        sendTextToElement(salaryMin, minSalary);

    }

    public void enterMaxSalary(String maxSalary) {
        Reporter.log("Entering Max Salary " + salaryMax.toString());
        sendTextToElement(salaryMax, maxSalary);

    }

    public void selectSalaryType(String sType) {
        Reporter.log("Selecting Salary Type " + salaryTypeDropDown.toString());
        selectByVisibleTextFromDropDown(salaryTypeDropDown, sType);


    }

    public void selectJobType(String jobType) {
        Reporter.log("Selecting Job Type " + jobTypeDropDown.toString());
        selectByVisibleTextFromDropDown(jobTypeDropDown, jobType);

    }

    public void clickOnFindJobsButton() {
        Reporter.log("Clicking on find jobs button " + findJobsBtn.toString());
        clickOnElement(findJobsBtn);

    }

    public void setAcceptCookies() {

        // driver.switchTo().frame(iframe);
        switchToIframe(iframe);
        System.out.println("we are switching to iFrame");
        clickOnElement(acceptCookies);//click on Acceptall
        System.out.println("We are done with iFrame");

        driver.switchTo().defaultContent();//switch to default window
    }


}
