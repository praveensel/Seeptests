package com.annectos.webdriver.TestCases;

import com.annectos.webdriver.Common.Staticprovider;
import com.annectos.webdriver.Common.Testbase;
import com.annectos.webdriver.PageObjects.LoginPageObjects;
import com.annectos.webdriver.PageObjects.My_Profile_PageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 4/18/14
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyProfileTestCase extends Testbase {

    @Test(dataProviderClass = Staticprovider.class, dataProvider = "XoloLogProvider")
    public void LoginPageAssert(String email, String Password) throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        LoginPageObjects loginPageObjects = PageFactory.initElements(getDriver(), LoginPageObjects.class);
        My_Profile_PageObjects myprofielObjects = PageFactory.initElements(getDriver(), My_Profile_PageObjects.class);
        loginPageObjects.OpenURl();
        loginPageObjects.assertEmailLabel();
        loginPageObjects.assertPasswordLabel();
        loginPageObjects.login(email,Password);
        myprofielObjects.gotoMyprofilePage();
        PageFactory.initElements(getDriver(), My_Profile_PageObjects.class);
        String FN=myprofielObjects.getfirstname();

    }
}
