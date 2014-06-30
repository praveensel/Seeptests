package com.annectos.webdriver.TestCases;

import com.annectos.webdriver.Common.Staticprovider;
import com.annectos.webdriver.Common.Testbase;
import com.annectos.webdriver.PageObjects.CatPageObjects;
import com.annectos.webdriver.PageObjects.HomePageObjects;
import com.annectos.webdriver.PageObjects.LoginPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 5/2/14
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Checkout extends Testbase {

    @Test(dataProviderClass = Staticprovider.class, dataProvider = "GoldLogin")
    public void CompleteTransaction(String email, String Password,String Level_0,String Level_1) throws Exception
    {
        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        LoginPageObjects loginPageObjects = PageFactory.initElements(getDriver(), LoginPageObjects.class);
        loginPageObjects.OpenURl();
        loginPageObjects.assertEmailLabel();
        loginPageObjects.assertPasswordLabel();
        loginPageObjects.login(email,Password);
        HomePageObjects homePageObjects=PageFactory.initElements(getDriver(),HomePageObjects.class);
        if(homePageObjects.Verify_the_Menu_isDispalyed(Level_0))
        {
            homePageObjects.HoverOverMenu(Level_0);
            homePageObjects.Click_On_Level_1_Menu(Level_1);
            homePageObjects.Get_ALL_Menus_from_home_page();

        }

        CatPageObjects catPageObjects=PageFactory.initElements(getDriver(),CatPageObjects.class);
        catPageObjects.getCurrentURL_and_extract_the_page_Catid_from_the_url();
        catPageObjects.click_on_a_product_from_cat_page();

    }
}
