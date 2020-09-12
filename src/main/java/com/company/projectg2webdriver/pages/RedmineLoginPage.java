package com.company.projectg2webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineLoginPage {

    protected WebDriver driver;

    private By txtUserName = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//*[@id='login-submit']");

    public RedmineLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public RedmineHomePage login(String username, String password){

        driver.findElement(txtUserName).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();

        return new RedmineHomePage(driver);

    }
}
