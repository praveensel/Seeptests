package com.annectos.webdriver.PageObjects;

import com.annectos.webdriver.Common.CommonMethods;
import com.annectos.webdriver.Helper.Logger;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 5/5/14
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class CatPageObjects extends CommonMethods {

    public CatPageObjects(WebDriver adriver) {
        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();
    }

    public List get_allProducts_From_the_page(String id) throws IOException, JSONException {
        List products=Products_page_api_reader("http://app.annectos.net/ecomm.api/store/prod_list_by_cat_short?cat_id="+id+"&min=0&max=0&json=true");
        System.out.println( products.size()) ;
        return products;
    }

    public String getCurrentURL_and_extract_the_page_Catid_from_the_url() throws IOException, JSONException {
        String URL=Get_Page_URL();
        Logger.Log(LOG_FILE,"getCurrentURL","Getting Page URL"+URL,driver,true);
        String id=URL.substring(URL.lastIndexOf("/")+1 );
        return id;

    }

    public void click_on_a_product_from_cat_page() throws IOException, JSONException {

        String Cat_id= getCurrentURL_and_extract_the_page_Catid_from_the_url();
        List Products=get_allProducts_From_the_page(Cat_id);
        System.out.print(Products.get(0));
        driver.findElement(By.cssSelector("a[href*='cf254']")).click();
        driver.findElement(By.cssSelector("href=#/prod/cf254"));
    }
}
