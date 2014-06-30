package com.annectos.webdriver.PageObjects;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/22/14
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */


import com.annectos.webdriver.Common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class HomePageObjects extends CommonMethods {

    @FindBy(xpath = "//*[@id='ng-app']/body/header/div[1]/div/div[2]/div[1]/div[2]/input")
    public WebElement searchForItems;

    @FindBy(xpath= "//img[@src='Content/customer_images/logo.png']")
    public WebElement BannerLogoimg;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[2]/a[2]/span/img")
    public WebElement eselectimg;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[2]/div[1]/div[1]")
    public WebElement CustomerText;

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrder;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[1]/a[2]")
    public WebElement WelcomeMessage;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[1]/a[1]")
    public WebElement SignOut;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/div[2]/div[2]/ul/li[1]/a/span[1]]")
    public WebElement Points;

    @FindBy(linkText ="MEN")
    @CacheLookup
    public WebElement MenuMen;

    @FindBy(linkText ="WOMEN")
    @CacheLookup
    public WebElement MenuWoMen;

    @FindBy(linkText ="KIDS")
    @CacheLookup
    public WebElement MenuKids;

    @FindBy(linkText ="MOBILES & TABLETS")
    @CacheLookup
    public WebElement MenuMobilesTablets;

    @FindBy(linkText ="HOME & KITCHEN")
    @CacheLookup
    public WebElement HomeKitchen;

    @FindBy(linkText ="NEW ARRIVALS")
    @CacheLookup
    public WebElement MenuNewarrivals;

    @FindBy(linkText ="SALE")
    @CacheLookup
    public WebElement MenuSale;

    @FindBy(linkText ="PREMIUM")
    @CacheLookup
    public WebElement Premium;

    @FindBy(linkText ="EXPRESS")
    @CacheLookup
    public WebElement Express;

    List<WebElement> Sub=driver.findElements(By.xpath("//*[@id=\"ng-app\"]/body/header/div[1]/div/ul"));

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/ul")
    @CacheLookup
    public WebElement MenuGrid;



    public HomePageObjects(WebDriver adriver) {
        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();
    }

    public void verifyLogo(String LogoPath)
    {
        waitforElementtoLoad(BannerLogoimg);
        try {
            String LogoString= BannerLogoimg.getAttribute("src");
            URL LogoURL = new URL(LogoString);
            imageCompare(LogoURL,LogoPath);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public void Get_ALL_Menus_from_home_page()
    {
      Findsubmneus(MenuGrid);
    }

    //HoverOverMenu will move the mouse over the menu
    public void HoverOverMenu(String MenuName )
    {
        if(MenuName.equalsIgnoreCase("MEN"))
        {
            HoverLevel_0_Menu(MenuMen);


        }  else if (MenuName.equalsIgnoreCase("WOMEN"))
        {
            HoverLevel_0_Menu(MenuWoMen);
        } else if (MenuName.equalsIgnoreCase("KIDS"))
        {
            HoverLevel_0_Menu(MenuKids);
        }else if (MenuName.equalsIgnoreCase("MOBILES & TABLETS"))
        {
            HoverLevel_0_Menu(MenuMobilesTablets);
        }else if (MenuName.equalsIgnoreCase("HOME & KITCHEN"))
        {
            HoverLevel_0_Menu(HomeKitchen);
        }else if (MenuName.equalsIgnoreCase("NEW ARRIVALS"))
        {
            HoverLevel_0_Menu(MenuNewarrivals);
        }else if (MenuName.equalsIgnoreCase("SALE"))
        {
            HoverLevel_0_Menu(MenuSale);
        }else if (MenuName.equalsIgnoreCase("PREMIUM"))
        {
            HoverLevel_0_Menu(Premium);
        }else if (MenuName.equalsIgnoreCase("EXPRESS"))
        {
            HoverLevel_0_Menu(Express);
        }

    }

    public boolean Verify_the_Menu_isDispalyed(String Level1Menu)
    {
        if(Level1Menu.equalsIgnoreCase("MEN"))
        {
            return MenuMen.isDisplayed();

        }
        else if (Level1Menu.equalsIgnoreCase("WOMEN"))
        {
            return (MenuWoMen.isDisplayed());
        }
        else if (Level1Menu.equalsIgnoreCase("KIDS"))
        {
            return (MenuKids.isDisplayed());
        }
        else if (Level1Menu.equalsIgnoreCase("MOBILES & TABLETS"))
        {
            return (MenuMobilesTablets.isDisplayed());

        }
        else if (Level1Menu.equalsIgnoreCase("HOME & KITCHEN"))
        {
            return(HomeKitchen.isDisplayed());

        }
        else if (Level1Menu.equalsIgnoreCase("NEW ARRIVALS"))
        {
            return (MenuNewarrivals.isDisplayed());

        }
        else if (Level1Menu.equalsIgnoreCase("SALE"))
        {
            return (MenuSale.isDisplayed());
        }
        else if (Level1Menu.equalsIgnoreCase("PREMIUM"))
        {
            return (Premium.isDisplayed());
        }
        else if (Level1Menu.equalsIgnoreCase("EXPRESS"))
        {
            return (Express.isDisplayed());
        }
       return false;
    }



    public void Click_On_Level_1_Menu(String Level_1)
    {
     WebElement Level_1_Menu= driver.findElement(By.linkText(Level_1));
     WaitforElementToLoadAndClick(Level_1_Menu);

    }


}

