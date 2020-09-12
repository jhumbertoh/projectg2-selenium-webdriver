package com.company.projectg2webdriver.base;

import com.company.projectg2webdriver.pages.RedmineLoginPage;
import com.company.projectg2webdriver.util.Urls;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static RedmineLoginPage redmineLoginPage;

    @BeforeClass
    public static void setUp(){

        String browserName = System.getenv("browserName");
        browserName = (browserName != null)? browserName.toLowerCase() : "";

        switch (browserName){
            case "firefox":
                setFirefoxDriverProperty();
                break;
            case "safari":
                setSafariDriverProperty();
                break;
            default:
                setChromeDriverProperty();
        }

        //driver.manage().window().maximize();
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Urls.REDMINE_LOGIN);
        redmineLoginPage = new RedmineLoginPage(driver);
    }

    private static void setChromeDriverProperty(){
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
        }
        else{
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        }
        driver = new ChromeDriver();
    }

    private static void setFirefoxDriverProperty(){
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
        }
        else{
            System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver");
        }
        driver = new FirefoxDriver();
    }

    private static void setSafariDriverProperty(){
         driver = new SafariDriver();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
