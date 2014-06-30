package com.annectos.webdriver.Common;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 1/13/14
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.io.File;




import java.io.File;

public class Properties extends Testbase{

    public static String userNamespan;
    public static String passwordspan;
    public static String userNamewipro;
    public static String passwordwipro;
    public static String userNamexolo;
    public static String passwordxolo;
    public static String wiproLogo;
    public static String userNamegold;
    public static String passwordgold;
    public static String Level1Menu;
    public static String Level0Menu;

    public static String userNameseep;
    public static String passwordseep;
    public static String firstnameSeep;
    public static String lastnameSeep;
    public static String MobileNoseep;
    public static String DOBSeep;
    public static String CFDSeep;
    public static String Educationseep;


    public static void setVariables() {

        userNamespan = XMLFunctions.getXMLConfiguration(CONFIG_FILE, "Span.email");
        passwordspan = XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Span.password");
        userNamewipro = XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Wipro.email");
        passwordwipro= XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Wipro.password");
        userNamexolo = XMLFunctions.getXMLConfiguration(CONFIG_FILE,"xolo.email");
        passwordxolo= XMLFunctions.getXMLConfiguration(CONFIG_FILE,"xolo.password");
        wiproLogo= XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Wipro.LogoLocation");
        Level1Menu=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Menu.Level1");
        Level0Menu=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"Menu.Level0");
        passwordgold=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"gold.password");
        userNamegold =XMLFunctions.getXMLConfiguration(CONFIG_FILE,"gold.email");

        //Seep
        userNameseep=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"seep.email");
        passwordseep=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"seep.password");
        firstnameSeep=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"seep.firstname");
        lastnameSeep=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"seep.lastname");
        DOBSeep=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"seep.DOB");
        CFDSeep=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"seep.CFD");
        Educationseep=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"seep.Education");
        MobileNoseep=XMLFunctions.getXMLConfiguration(CONFIG_FILE,"seep.mobileNo");

    }






}

