package com.company.projectg2webdriver.redmine;

import com.company.projectg2webdriver.base.BaseTest;
import com.company.projectg2webdriver.pages.RedmineHomePage;
import com.company.projectg2webdriver.pages.RedmineLoginPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedmineTest extends BaseTest {


    @BeforeClass
    public static void launchApp(){

        driver.get("http://localhost:8081/login");
    }

    @Test
    public void login(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8081/");

        driver.manage().window().maximize();

        //driver.manage().window().fullscreen();

        //driver.manage().window().setSize(new Dimension(375,812));

        System.out.println(driver.getTitle());

        Assert.assertEquals("Redmine", driver.getTitle());

        WebElement linkLogin = driver.findElement(By.xpath("//*[@id='account']/ul/li[1]/a"));
        linkLogin.click();

        //----> XPATH Relativo - User
        //----> //*[@id="username"]

        //---> XPATH FULL - User
        //---> /html/body/div/div[2]/div[1]/div[3]/div[2]/div[1]/form/input[4]

        WebElement txtUsername = driver.findElement(By.id("username"));
        txtUsername.sendKeys("user");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("bitnami1");

        WebElement btnLogin = driver.findElement(By.xpath("//*[@id='login-submit']"));
        btnLogin.click();

        WebElement lblLogin = driver.findElement(By.xpath("//*[@id='loggedas']"));
        String actualUser = lblLogin.getText();
        String expectedUser = "Logged in as user";

        Assert.assertEquals(expectedUser, actualUser);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }

    @Test
    public void loginRedmine(){

        String user = "user", password = "bitnami1";
        String userExpected = "Logged in as user";

        RedmineLoginPage redmineLoginPage = new RedmineLoginPage(driver);
        RedmineHomePage redmineHomePage = redmineLoginPage.login(user,password);

        String userActual = redmineHomePage.getUserLogged();

        Assert.assertEquals(userExpected, userActual);

    }
}