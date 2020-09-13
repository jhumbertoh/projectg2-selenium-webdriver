package com.company.projectg2webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage extends RedmineLoginPage{

    private By menuMyPage = By.xpath("//a[@href='/my/page']");
    private By menuProjects = By.xpath("//a[@href='/projects']");
    private By menuMyAdmin = By.xpath("//a[@href='/admin']");


    private By lblUserLogged = By.xpath("//*[@id='loggedas']");

    public RedmineHomePage(WebDriver driver){
        super(driver);
    }

    public String getUserLogged(){
        return driver.findElement(lblUserLogged).getText();
    }

    public RedmineLoginPage clickOnLink(String option){

        switch (option.toLowerCase()){

            case "my page":
                driver.findElement(menuMyPage).click();
                return new RedmineLoginPage(driver);
            case "projects":
                driver.findElement(menuProjects).click();
                return new RedmineProjectsPage(driver);
            case "administration":
                driver.findElement(menuMyAdmin).click();
                return new RedmineUsersPage(driver);
            default:
                throw new IllegalStateException("La opción "+option.toLowerCase() + " no esta presente");
        }
    }
}