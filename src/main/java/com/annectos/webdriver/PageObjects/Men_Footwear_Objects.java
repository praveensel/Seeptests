package com.annectos.webdriver.PageObjects;



import com.annectos.webdriver.Common.CommonMethods;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Men_Footwear_Objects extends CommonMethods {

    @FindBy(xpath = "/html/body/ul/li[1]/div/span[2]/input")
    public WebElement brandfilter1;

    @FindBy(xpath = "/html/body/ul/li[1]/div/span[3]/input")
    public WebElement brandfilter2;

    @FindBy(xpath = "/html/body/ul/li[1]/div/span[4]/input")
    public WebElement brandfilter3;

    @FindBy(xpath = "/html/body/ul/li[2]/span[2]/div[1]/input")
    public WebElement PriceMinimumRange;

    @FindBy(xpath = "/html/body/ul/li[2]/span[2]/div[2]/input")
    public WebElement PriceMaximumRange;

    @FindBy(xpath = "/html/body/ul/li[2]/span[2]/input")
    public WebElement PricerangeGobtn;

    @FindBy(xpath = "/html/body/ul/li[4]/span[2]/p[1]/input")
    public WebElement DiscountFilter1;

    @FindBy(xpath = "/html/body/ul/li[4]/span[2]/p[2]/input")
    public WebElement DiscountFilter2;

    @FindBy(xpath = "/html/body/ul/li[4]/span[2]/p[3]/input")
    public WebElement DiscountFilter3;

    @FindBy(xpath = "/html/body/ul/li[4]/span[2]/p[4]/input")
    public WebElement DiscountFilter4;

    @FindBy(xpath = "//*[@id=\"ng-app\"]/body/header/div[1]/div/ul/li[1]/ul")
    List<WebElement> MenList;



    public Men_Footwear_Objects(WebDriver adriver) {
        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();
    }

    public void click_on_product()

    {

    }
}
