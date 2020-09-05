package com.company.projectg2webdriver.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");

        driver = new ChromeDriver();

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
