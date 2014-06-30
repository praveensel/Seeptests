package com.annectos.webdriver.PageObjects.SeepClaim;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/16/14
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */


import com.annectos.webdriver.Common.CommonMethods;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageObject extends CommonMethods{

    @FindBy(css = "Input[placeholder=\"First Name\"]")
    public WebElement elmFirstName;

    @FindBy(css = "Input[ng-model=\"user_data.last_name\"]")
    public WebElement elmlasttName;

    @FindBy(css = "Input[ng-model=\"user_data.email_id\"]")
    public WebElement elmEmailid;

    @FindBy(css = "Input[ng-model=\"user_data.mobile_no\"]")
    public WebElement elmPhoneNo;

    @FindBy(css = "Input[ng-model=\"user_data.user_date_of_birth\"]")
    public WebElement elmDOB;

    @FindBy(css = "Input[ng-model=\"user_data.cmp_found_dt\"]")
    public WebElement elmCFD;

    @FindBy(css = "Input[ng-model=\"user_data.qualification\"]")
    public WebElement elmEducation;

    @FindBy(css = "Input[value=\"Save\"]")
    public WebElement elmSave;

    @FindBy(xpath = "//div[@class='tablecolorborder']//div[.='WORK INFORMATION']")
    public WebElement elmWORKINFORMATION;

    @FindBy(xpath = "//div[@class='workinfo']//span[.='COMPANY NAME : ']")
    public WebElement elmCOMPANYNAME;

    @FindBy(xpath = "//div[@class='workinfo']//span[.='DESIGNATION : '] ")
    public WebElement elmDESIGNATION ;

    @FindBy(xpath = "//div[@class='workinfo']//span[.='PARTNER ID : ']")
    public WebElement elmPARTNERID;

    @FindBy(xpath = "//div[@class='workinfo']//span[.='ZONE : South'] ")
    public WebElement elmZONE ;

    @FindBy(xpath = "//div[@class='workinfo']//span[.='CITY : ']")
    public WebElement elmCITY ;

    @FindBy(xpath = "//div[@class='tablecolorborder']//div[.='SETTINGS']")
    public WebElement elmSETTINGS ;

    @FindBy(xpath = "//div[@class='tablecolorborder']//label[.='First Name']")
    public WebElement elmProfile_LabelFirstName;

    @FindBy(xpath = "//div[@class='tablecolorborder']//label[.='Last Name']")
    public WebElement elmProfile_LabelLastName;

    @FindBy(xpath = "//div[@class='tablecolorborder']//label[.='Email']")
    public WebElement elmProfile_LabelEmail;

    @FindBy(xpath = "//div[@class='tablecolorborder']//label[.='Phone No']")
    public WebElement elmProfile_Phone_no;

    @FindBy(xpath = "//div[@class='tablecolorborder']//label[.='Gender']")
    public WebElement elmProfile_Gender;

    @FindBy(xpath = "//div[@class='tablecolorborder']//label[.='Date of Birth']")
    public WebElement elmProfile_Date_of_Birth;

    @FindBy(xpath = "//div[@class='tablecolorborder']//label[.='Company Founded Date']")
    public WebElement elmProfile_Company_Founded_Date;

    @FindBy(xpath = "//div[@class='tablecolorborder']//label[.='Education']")
    public WebElement elmProfile_Education;
    
    
    @FindBy(css = "Input[ng-model=\"selected_address.first_name\"]")
    @CacheLookup
    public WebElement selected_address_first_name;

    @FindBy(css = "Input[ng-model=\"selected_address.last_name\"]")
    @CacheLookup
    public WebElement selected_address_last_name ;
    
    
   @FindBy(css = "textarea[ng-model=\"selected_address.address\"]")
   @CacheLookup
   public WebElement selected_address_address;

  @FindBy(css = "Input[ng-model=\"selected_address.street\"]")
  @CacheLookup
  public WebElement selected_address_street;
    
    @FindBy(css = "Input[ng-model=\"selected_address.city\"]")
    @CacheLookup
    public WebElement selected_address_city ;

    @FindBy(css = "select[ng-model=\"selected_address.state\"]")
    @CacheLookup
    public WebElement selected_address_State ;


   @FindBy(css = "Input[ng-model=\"selected_address.zipcode\"]")
   @CacheLookup
   public WebElement selected_address_zipcode;
    
    @FindBy(css = "Input[ng-model=\"selected_address.mobile_no\"]")
    @CacheLookup
    public WebElement selected_address_mobile_no;

    @FindBy(xpath= "//div[2]/div/div[2]/div/div[3]/div[2]/div/p[10]/input")
    public WebElement update_save_btn;

    public ProfilePageObject (WebDriver adriver) {

        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();

    }
    public void checkAllElements()
    {
        assertElementPresent(selected_address_State);
        assertElementPresent(elmFirstName);
        assertElementPresent(elmlasttName);
        assertElementPresent(elmCFD);
        assertElementPresent(elmCITY);
        assertElementPresent(elmCOMPANYNAME);
        assertElementPresent(elmDESIGNATION);
        assertElementPresent(elmDOB);
        assertElementPresent(elmEmailid);
        assertElementPresent(elmPhoneNo);
        assertElementPresent(elmPARTNERID);
        assertElementPresent(elmZONE);
        assertElementPresent(elmSETTINGS);
        assertElementPresent(elmProfile_LabelFirstName);
        assertElementPresent(elmProfile_LabelLastName);
        assertElementPresent(elmProfile_LabelEmail);
        assertElementPresent(elmProfile_Phone_no);
        assertElementPresent(elmProfile_Gender);
        assertElementPresent(elmProfile_Date_of_Birth);
        assertElementPresent(elmProfile_Company_Founded_Date);
        assertElementPresent(elmProfile_Education);
        assertElementPresent(elmWORKINFORMATION);
        assertElementPresent(elmEducation);
        assertElementPresent(elmSave);
        assertElementPresent(selected_address_first_name);
        assertElementPresent(selected_address_last_name);
        assertElementPresent(selected_address_address);
        assertElementPresent(selected_address_street);
        assertElementPresent(selected_address_city);

        assertElementPresent(selected_address_zipcode);
        assertElementPresent(selected_address_mobile_no);
        assertElementPresent(update_save_btn);

    }

    //
    public void type_firstname_in_profiletab(String Firstname)
    {
        sendtext(elmFirstName,Firstname);
    }

    public void type_Lasttname_in_profiletab(String Lastname)
    {
        sendtext(elmlasttName,Lastname);
    }

    public void  type_phone_number_in_profile_tab(String PhoneNo)
    {
        sendtext(elmPhoneNo,PhoneNo);
    }

    public void type_DOB_profile_tab(String DOB)
    {
        sendtext(elmDOB,DOB);
    }

    public void type_CFD_profile_tab(String CFD)
    {
        sendtext(elmCFD,CFD);
    }

    public void type_Education_profile_tab(String Edu)
    {
        sendtext(elmEducation,Edu);
    }

    public void Click_Save_Button_In_profile_tab()
    {
        WaitforElementToLoadAndClick(elmSave);
    }

    public void type_firstname_in_AddressTab(String Firstname)
    {
        sendtext(selected_address_first_name,Firstname);
    }

    public void type_Last_name_in_AddressTab(String Lastname)
    {
        sendtext(selected_address_last_name,Lastname);
    }

    public void type_Landmark_in_AddressTab(String Landmark)
    {
        sendtext(selected_address_street,Landmark);
    }

    public void type_City_in_AddressTab(String Landmark)
    {
        sendtext(selected_address_city,Landmark);
    }

    public void type_Zip_code_in_address_tab(String Zipcode)
    {
        sendtext(selected_address_zipcode,Zipcode);
    }

    public void type_phone_no_in_address_tab(String Mobileno)
    {
        sendtext(selected_address_mobile_no,Mobileno);
    }


   public void Save_profile_without_First_name(String FirstName,String Lastname,String PhoneNo,String DOB,String CFD,String Education )
   {
       type_Lasttname_in_profiletab(Lastname);
       type_phone_number_in_profile_tab(PhoneNo);
       type_DOB_profile_tab(DOB);
       type_CFD_profile_tab(CFD);
       type_Education_profile_tab(Education);
       Click_Save_Button_In_profile_tab();
       waitForAlertAndAccept("Please enter firt name");

   }



 }

