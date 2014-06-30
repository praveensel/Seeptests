package com.annectos.webdriver.Common;

/**
 * Created with IntelliJ IDEA.
 * User: QA-002
 * Date: 12/27/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.annectos.webdriver.Common.Properties.*;


public class Testbase {

    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    public ThreadLocal<WebDriver> driver=null;
    public static File CONFIG_FILE;
    public static String baseURL;

    @Parameters({"URL"})
    @BeforeClass ()

    public void beforeclass(String URL)
    {
        CONFIG_FILE= new File("D:\\dev\\Selenium\\Automatedtests\\src\\Resources\\Credentials.xml");
        System.out.print(baseURL);
        baseURL =URL  ;
        com.annectos.webdriver.Common.Properties.setVariables();
        System.setProperty("org.uncommons.reportng.escape-output", "false");
      //  System.setProperty("webdriver.chrome.driver", "D:\\dev\\Selenium\\Automatedtests\\src\\Resources\\Driver\\chromedriver.exe");
        //System.setProperty("org.uncommons.reportng.stylesheet","E:\\AnnectosAutomatedTesting\\test-output\\html\\ReportngEdit.css");
    }
    @Parameters({"browser","RunMode","HostUrl","PlatformName","browserVersion","URL"})
    @BeforeSuite()
    public void setUp(String browser,
                      String RunMode ,
                      @Optional("http://localhost:4444/wd/hub")String HostUrl,
                      String PlatformName,
                      String browserVersion,
                      String URL)                    throws MalformedURLException {


        //System.setProperty("webdriver.chrome.driver", "\\src\\main\\resources\\chromedriver.exe");

        if ((browser.equalsIgnoreCase("chrome"))) {

            if(RunMode.equalsIgnoreCase("Grid"))
            {
                threadDriver = new ThreadLocal<RemoteWebDriver>();
                //DesiredCapabilities caps = new DesiredCapabilities();
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "35");
              //  threadDriver.set(new RemoteWebDriver (new URL("http://localhost:4444/wd/hub"), caps));
               threadDriver.set(new RemoteWebDriver(new URL("http://praveenk82:3fb2157e-53e3-4c5d-8cf1-0b8131a08d74@ondemand.saucelabs.com:80/wd/hub"),caps));
              //  baseURL=  baseURL1;
            }

            else
            {
                driver = new ThreadLocal<WebDriver>();
                driver.set(new ChromeDriver());

            }

        }
        if ((browser.equalsIgnoreCase("Firefox"))) {

            if(RunMode.equalsIgnoreCase("Grid"))
            {
                threadDriver = new ThreadLocal<RemoteWebDriver>();
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName(browser);
                caps.setCapability("platform", PlatformName);
                caps.setBrowserName(browser);
                caps.setVersion(browserVersion);

                threadDriver.set(new RemoteWebDriver(caps));

                //threadDriver.set(new RemoteWebDriver(new URL("http://PraveenSelenium:dc653317-36d8-44d8-88a0-76816c4fd7b5@ondemand.saucelabs.com:80/wd/hub"),caps));

            }
            else
            {

                driver = new ThreadLocal<WebDriver>();
                driver.set(new FirefoxDriver());
            }

        }
        if ((browser.equalsIgnoreCase("iexplorer"))) {

            if(RunMode.equalsIgnoreCase("Grid"))
            {
                threadDriver = new ThreadLocal<RemoteWebDriver>();
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", PlatformName);
                caps.setVersion(browserVersion);
                //threadDriver.set(new RemoteWebDriver(caps));
               threadDriver.set(new RemoteWebDriver(new URL("http://PraveenSelenium:3fb2157e-53e3-4c5d-8cf1-0b8131a08d74@ondemand.saucelabs.com:80/wd/hub"),caps));

            }
            else
            {

                driver = new ThreadLocal<WebDriver>();
                driver.set(new FirefoxDriver());
            }
        }
    }

    public WebDriver getDriver()
    {
        System.out.println(threadDriver);
        if(threadDriver==null)
        {
            System.out.println("returning driver");
            return driver.get();
        }
        else
        {
            System.out.println("returning thread driver");
            return threadDriver.get();
        }
    }

    @AfterMethod
    public void closeBrowser() {
        if(threadDriver!=null)
        {
            getDriver().quit();
        }
        else
        {
           // driver.get().quit();
        }

    }public void findRemoteip(RemoteWebDriver driver) throws IOException, JSONException {
        HttpCommandExecutor ce = (HttpCommandExecutor) driver.getCommandExecutor();
        ce.getAddressOfRemoteServer();
        ce.getAddressOfRemoteServer().getHost();
        String yourHubIP=ce.getAddressOfRemoteServer().getHost();
        int yourHubPort=ce.getAddressOfRemoteServer().getPort();
        HttpHost host = new HttpHost(ce.getAddressOfRemoteServer().getHost(), yourHubPort);
        DefaultHttpClient client = new DefaultHttpClient();
        URL testSessionApi = new URL("http://" + yourHubIP + ":" + yourHubPort + "/grid/api/testsession?session=" +  driver.getSessionId());
        BasicHttpEntityEnclosingRequest r = new  BasicHttpEntityEnclosingRequest("POST", testSessionApi.toExternalForm());
        HttpResponse response  = client.execute(host,r);
        JSONObject object = new JSONObject(EntityUtils.toString(response.getEntity()));
        String proxyID =(String) object.get("proxyId");

        Reporter.log(
                "<tr class=\"Runconfig\">" + "<th colspan=\"3\" width=\"100%\">" + "Test Run at following config " +
                        "Ip address of the system test run at " + proxyID +
                        " Browser Name " + driver.getCapabilities().getBrowserName() + "\n" +
                        "\n" + "Platform Name " + driver.getCapabilities().getPlatform() + "\n" +
                        "\n" + "Browser Version " + driver.getCapabilities().getVersion() + "</th></tr>");
    }
}