package com.company.projectg2webdriver.base;

import com.company.projectg2webdriver.pages.RedmineLoginPage;
import com.company.projectg2webdriver.util.Urls;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;
    protected static RedmineLoginPage redmineLoginPage;

    @BeforeClass
    public static void setUp(){

        setChromeDriverProperty();

        driver = new ChromeDriver();
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
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
