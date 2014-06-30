package com.annectos.webdriver.PageObjects.SeepClaim;

import com.annectos.webdriver.Common.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/24/14
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeepHomePageObjects extends CommonMethods {

    @FindBy(partialLinkText = "HOME")
    public WebElement elmHomeMenu;

    @FindBy(partialLinkText = "PROFILE")
    public  WebElement elmPROFILEMenu;

    @FindBy(partialLinkText = "SEEP")
    public  WebElement elmSEEPMenu;

    @FindBy(partialLinkText = "CLAIM ENTRY")
    public  WebElement elmCLAIMENTRYMenu;

    @FindBy(partialLinkText = "MY CLAIMS")
    public  WebElement elmMYCLAIMSMenu;

    @FindBy(partialLinkText = "REDEMPTION")
    public  WebElement elMREDEMPTIONMenu;

    @FindBy(partialLinkText = "REWARD GALLERY")
    public  WebElement elmREWARDMenu;

    @FindBy(partialLinkText = "CONTACT")
    public  WebElement elmCONTACTMenu;

    @FindBy(partialLinkText = "SPECIAL")
    public  WebElement elmSPECIALMenu;

    @FindBy(partialLinkText = "CHANGE PASSWORD")
    public  WebElement elmCHNGPWDMenu;

    @FindBy(partialLinkText = "LOGOUT")
    public  WebElement elmLOGOUTMenu;

    @FindBy(css = "footer")
    public  WebElement elmFooter;

    @FindBy(css="a.left.carousel-control")
    public WebElement elmLeftarrow;

    @FindBy(css="a.right.carousel-control")
    public WebElement elmRightarrow;

    @FindBy(xpath = "//div[@class='carousel-inner']/div[2]/a/img")
    public WebElement elmImageBird;

    @FindBy(xpath = "//div[@class='carousel-inner']/div[1]/a/img")
    public WebElement elmImageGrowing;

    @FindBy(css="img.pull-left")
    public WebElement elmLogoLeft;

    @FindBy(css="img.pull-right")
    public WebElement elmLogoRight;


    public SeepHomePageObjects(WebDriver adriver) {
        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();
    }
    public void checkAllMenus()
    {

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
        assertElementPresent(elmImageGrowing);
        assertElementPresent(elmImageBird);
        assertElementPresent(elmLeftarrow);
        assertElementPresent(elmRightarrow);
        assertElementPresent(elmFooter) ;
        assertElementPresent(elmLogoLeft);
        assertElementPresent(elmLogoRight);
    }

    public void OpenURl()
    {
        driver.navigate().to(baseURL);
    }
}
