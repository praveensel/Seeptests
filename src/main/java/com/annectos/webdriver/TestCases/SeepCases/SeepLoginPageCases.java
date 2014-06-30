package com.annectos.webdriver.TestCases.SeepCases;

import com.annectos.webdriver.Common.Staticprovider;
import com.annectos.webdriver.Common.Testbase;
import com.annectos.webdriver.PageObjects.HomePageObjects;
import com.annectos.webdriver.PageObjects.LoginPageObjects;
import com.annectos.webdriver.PageObjects.SeepClaim.SeepLoginPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/24/14
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeepLoginPageCases extends Testbase {

    @Test(dataProviderClass = Staticprovider.class,dataProvider="SeepData")
    public void it_should_dispaly_all_the_menus(String email, String Password,String LogoPath) throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        SeepLoginPageObjects seepLoginpgobj=PageFactory.initElements(getDriver(),SeepLoginPageObjects.class);
        seepLoginpgobj.OpenURl();
        seepLoginpgobj.checkAllMenus();


    }


    @Test(dataProviderClass = Staticprovider.class,dataProvider="SeepData")
    public void it_should_give_an_alert_saying_Crdentials_dont_match(String email, String Password)  throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
    {
        SeepLoginPageObjects seepLoginpgobj=PageFactory.initElements(getDriver(),SeepLoginPageObjects.class);
        seepLoginpgobj.OpenURl();
        seepLoginpgobj.Login_without_passowrd(email);

    }

    }

    @Test(dataProviderClass = Staticprovider.class,dataProvider="SeepData")
    public void it_should_give_an_alert_saying_Crdentials_dont_match_(String email, String Password)  throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        {
            SeepLoginPageObjects seepLoginpgobj=PageFactory.initElements(getDriver(),SeepLoginPageObjects.class);
            seepLoginpgobj.OpenURl();
            seepLoginpgobj.Login_without_email(Password);

        }

    }

    @Test(dataProviderClass = Staticprovider.class,dataProvider="SeepData")
    public void it_should_Login_successfully_(String email, String Password)  throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        {
            SeepLoginPageObjects seepLoginpgobj=PageFactory.initElements(getDriver(),SeepLoginPageObjects.class);
            seepLoginpgobj.OpenURl();
            seepLoginpgobj.Login_with_both_Email_and_Password(email,Password);
            seepLoginpgobj.Profile();

        }

    }

}
