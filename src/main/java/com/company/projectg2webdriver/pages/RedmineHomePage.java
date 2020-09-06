package com.company.projectg2webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage {

    private WebDriver driver;

    private By menuMyPage = By.xpath("//a[@href='/my/page']");
    private By menuProjects = By.xpath("//a[@href='/projects']");
    private By menuMyAdmin = By.xpath("//a[@href='/admin']");


    private By lblUserLogged = By.xpath("//*[@id='loggedas']");

    public RedmineHomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getUserLogged(){
        return driver.findElement(lblUserLogged).getText();
    }

    public RedmineProjectsPage clickOnLink(String option){

        switch (option.toLowerCase()){

            case "my page":
                driver.findElement(menuMyPage).click();
                break;
            case "projects":
                driver.findElement(menuProjects).click();
                break;
            case "administration":
                driver.findElement(menuMyAdmin).click();
                break;
            default:
                throw new IllegalStateException("La opción "+option.toLowerCase() + " no esta presente");
        }

        return new RedmineProjectsPage(driver);
    }
}