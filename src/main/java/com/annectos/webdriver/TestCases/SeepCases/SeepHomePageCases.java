package com.annectos.webdriver.TestCases.SeepCases;


import com.annectos.webdriver.Common.Staticprovider;
import com.annectos.webdriver.Common.Testbase;
import com.annectos.webdriver.PageObjects.SeepClaim.SeepLoginPageObjects;
import com.annectos.webdriver.PageObjects.SeepClaim.SeepHomePageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/24/14
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeepHomePageCases extends Testbase {

    @Test(dataProviderClass = Staticprovider.class,dataProvider="SeepData")
    public void it_should_dispaly_all_the_menus(String email, String Password) throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        SeepHomePageObjects seepHomePageObjects= PageFactory.initElements(getDriver(), SeepHomePageObjects.class);
        SeepLoginPageObjects seepLoginpgobj=PageFactory.initElements(getDriver(),SeepLoginPageObjects.class);
        seepLoginpgobj.OpenURl();
        seepLoginpgobj.Login_with_both_Email_and_Password(email,Password);
        seepHomePageObjects.checkAllMenus();


    }
}
