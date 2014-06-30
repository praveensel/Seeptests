package com.annectos.webdriver.TestCases.SeepCases;

import com.annectos.webdriver.Common.Staticprovider;
import com.annectos.webdriver.Common.Testbase;
import com.annectos.webdriver.PageObjects.SeepClaim.SeepLoginPageObjects;
import com.annectos.webdriver.PageObjects.SeepClaim.ProfilePageObject;
import org.openqa.selenium.support.PageFactory;
import com.annectos.webdriver.TestCases.SeepCases.*;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/24/14
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeepProfilePageCases extends Testbase{

    @Test(dataProviderClass = Staticprovider.class,dataProvider="SeepData")
    public void all_element_present(String email, String Password ) throws Exception

    {
        if(threadDriver!=null)
        {
            //findRemoteip(threadDriver.get());
        }
        {
            SeepLoginPageObjects seepLoginpgobj= PageFactory.initElements(getDriver(), SeepLoginPageObjects.class);
            ProfilePageObject profilePageObject=PageFactory.initElements(getDriver(),ProfilePageObject.class);
            seepLoginpgobj.OpenURl();
            seepLoginpgobj.Login_with_both_Email_and_Password(email,Password);
            seepLoginpgobj.Profile();
            profilePageObject.checkAllElements();
            seepLoginpgobj.Logout();

        }
    }

    @Test(dataProviderClass = Staticprovider.class,dataProvider="SeepProfileData")
    public void It_should_give_alert_to_enter_first_name(String email, String Password,String Firstname,String LastName,String DOB,String CFD,String MobileNo,String Education) throws Exception

    {
        if(threadDriver!=null)
        {
            //findRemoteip(threadDriver.get());
        }
        {
            SeepLoginPageObjects seepLoginpgobj= PageFactory.initElements(getDriver(), SeepLoginPageObjects.class);
           ProfilePageObject profilePageObject=PageFactory.initElements(getDriver(),ProfilePageObject.class);
            seepLoginpgobj.OpenURl();
            seepLoginpgobj.Login_with_both_Email_and_Password(email,Password);
            seepLoginpgobj.Profile();
            profilePageObject.Save_profile_without_First_name(Firstname,LastName,MobileNo,DOB,CFD,Education);
            seepLoginpgobj.Logout();

        }
    }

}
