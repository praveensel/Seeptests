package com.annectos.webdriver.PageObjects.SeepClaim;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/24/14
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */



import com.annectos.webdriver.Common.CommonMethods;
import com.sun.corba.se.impl.logging.InterceptorsSystemException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeepLoginPageObjects extends CommonMethods {

    @FindBy(css = "Input[ng-model=\"email_id\"]")
    public WebElement registeredEMail;

    @FindBy(css = "Input[ng-model=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit' and @value='Submit']")
    public WebElement submit;

    @FindBy(partialLinkText = "HOME")
    public WebElement elmHomeMenu;

    @FindBy(partialLinkText = "PROFILE")
    public WebElement elmPROFILEMenu;

    @FindBy(partialLinkText = "SEEP")
    public WebElement elmSEEPMenu;

    @FindBy(partialLinkText = "CLAIM ENTRY")
    public WebElement elmCLAIMENTRYMenu;

    @FindBy(partialLinkText = "MY CLAIMS")
    public WebElement elmMYCLAIMSMenu;

    @FindBy(partialLinkText = "REDEMPTION")
    public WebElement elMREDEMPTIONMenu;

    @FindBy(partialLinkText = "REWARD GALLERY")
    public WebElement elmREWARDMenu;

    @FindBy(partialLinkText = "CONTACT")
    public WebElement elmCONTACTMenu;

    @FindBy(partialLinkText = "SPECIAL")
    public WebElement elmSPECIALMenu;

    @FindBy(partialLinkText = "CHANGE PASSWORD")
    public WebElement elmCHNGPWDMenu;

    @FindBy(partialLinkText = "LOGOUT")
    public WebElement elmLOGOUTMenu;

    public SeepLoginPageObjects(WebDriver adriver) {

        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();

    }

    public void OpenURl() {
        driver.navigate().to(baseURL);
    }

    public void checkAllMenus() {
        assertElementPresent(registeredEMail);
        assertElementPresent(password);
        assertElementPresent(submit);
        assertElementPresent(elmHomeMenu);
        assertElementPresent(elmPROFILEMenu);
        assertElementPresent(elmSEEPMenu);
        assertElementPresent(elmCLAIMENTRYMenu);
        assertElementPresent(elmMYCLAIMSMenu);
        assertElementPresent(elmREWARDMenu);
        assertElementPresent(elmPROFILEMenu);
        assertElementPresent(elmCONTACTMenu);
        assertElementPresent(elmSPECIALMenu);
        assertElementPresent(elmCHNGPWDMenu);
        assertElementPresent(elmLOGOUTMenu);


    }

    public void TypeUsername(String email) {
        waitforElementtoLoad(registeredEMail);
        SetText(registeredEMail, email);
    }

    public void TypePassword(String Password) {
        waitforElementtoLoad(password);
        SetText(password, Password);
    }

    public void click_submit_button() {
        WaitforElementToLoadAndClick(submit);


    }

    public void Logout() {
        WaitforElementToLoadAndClick(elmLOGOUTMenu);
    }

    public void Profile() {
        WaitforElementToLoadAndClick(elmPROFILEMenu);
    }


    public void Login_without_passowrd(String email) {
        TypeUsername(email);
        click_submit_button();
        waitForAlertAndAccept("Sorry - your credentials don't match with what we have in file");
    }

    public void Login_without_email(String password) {
        TypePassword(password);
        click_submit_button();
        waitForAlertAndAccept("Sorry - your credentials don't match with what we have in file");
    }

    public void Login_with_both_Email_and_Password(String email, String Password) throws InterruptedException {
        TypeUsername(email);
        TypePassword(Password);
        click_submit_button();
        waitForAlertAndAccept("Login Successful. Now you will be redirected to home page ...");


    }


}