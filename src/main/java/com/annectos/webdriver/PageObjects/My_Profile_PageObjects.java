package com.annectos.webdriver.PageObjects;

import com.annectos.webdriver.Common.CommonMethods;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class My_Profile_PageObjects extends CommonMethods {

    @FindBy(css = "Input[ng-model=\"my_profile.first_name\"]")
    @CacheLookup
    public WebElement MP_Firstname;

    @FindBy(css = "Input[ng-model=\"my_profile.email_address\"]")
    @CacheLookup
    public WebElement my_profile_email_address ;

   @FindBy(css = "Input[ng-model=\"my_profile.last_name\"]")
   @CacheLookup
   public WebElement my_profile_last_name;

    @FindBy(css = "Input[ng-model=\"my_profile.mobile_no\"]")
    @CacheLookup
    public WebElement my_profile_mobile_no;





    public My_Profile_PageObjects(WebDriver adriver) {
        super(driver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();
    }

    public String getfirstname()
    {
          return MP_Firstname.getAttribute("value") ;
    }

    public void gotoMyprofilePage()
    {
        driver.get(baseURL+"/index.html#/my_profile");
    }
}