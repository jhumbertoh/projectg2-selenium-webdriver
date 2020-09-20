package com.company.projectg2webdriver.base;

import com.company.projectg2webdriver.pages.RedmineLoginPage;
import com.company.projectg2webdriver.util.Urls;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static RedmineLoginPage redmineLoginPage;

    @BeforeClass
    public static void setUp(){

        String browserName = System.getenv("browserName");
        browserName = (browserName != null)? browserName.toLowerCase() : "";

        //String webDriverRemote = System.getenv("webDriverRemote");
        //Boolean isWebDriverRemote = (webDriverRemote != null)? Boolean.parseBoolean(webDriverRemote.toLowerCase()) : Boolean.parseBoolean("false");


        switch (browserName){
            case "firefox":
                /*if(isWebDriverRemote)
                    setChromeDriverPropertyLocal();
                else
                   setFirefoxDriverPropertyRemote(browserName);
                 */
                setFirefoxDriverProperty(browserName);
                break;
            case "safari":
                setSafariDriverProperty(browserName);
                break;
            default:
                setChromeDriverProperty("chrome");
        }

        //driver.manage().window().maximize();
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Urls.REDMINE_LOGIN);
        redmineLoginPage = new RedmineLoginPage(driver);
    }

    private static void setChromeDriverProperty(String browserName){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName(browserName);

        try {
            URL hubUrl = new URL(Urls.SELENIUM_GRID);
            driver = new RemoteWebDriver(hubUrl,capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private static void setFirefoxDriverProperty(String browserName){

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName(browserName);

        try {
            URL hubUrl = new URL(Urls.SELENIUM_GRID);
            driver = new RemoteWebDriver(hubUrl,capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void setSafariDriverProperty(String browserName){

        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        capabilities.setBrowserName(browserName);

        try {
            URL hubUrl = new URL(Urls.SELENIUM_GRID);
            driver = new RemoteWebDriver(hubUrl,capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
