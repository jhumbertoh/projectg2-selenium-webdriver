package com.company.projectg2webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage {

    private WebDriver driver;

    private By lblUserLogged = By.xpath("//*[@id='loggedas']");

    public RedmineHomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getUserLogged(){
        return driver.findElement(lblUserLogged).getText();
    }
}
