package com.annectos.webdriver.TestCases;

import com.annectos.webdriver.Common.Staticprovider;
import com.annectos.webdriver.Common.Testbase;
import com.annectos.webdriver.PageObjects.HomePageObjects;
import com.annectos.webdriver.PageObjects.LoginPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/28/14
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomePageTestCases extends Testbase {

    @Test(dataProviderClass = Staticprovider.class, dataProvider = "WiproLoginplusLogProvider")
    public void LoginAndCheckLogo(String email, String Password,String LogoPath) throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        LoginPageObjects loginPageObjects = PageFactory.initElements(getDriver(), LoginPageObjects.class);
        HomePageObjects homePageObjects=PageFactory.initElements(getDriver(),HomePageObjects.class);
        loginPageObjects.OpenURl();
        loginPageObjects.assertEmailLabel();
        loginPageObjects.assertPasswordLabel();
        loginPageObjects.login(email,Password);
        homePageObjects.verifyLogo(LogoPath);

    }
}
