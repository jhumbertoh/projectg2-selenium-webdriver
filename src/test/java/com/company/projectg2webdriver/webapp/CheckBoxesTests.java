package com.company.projectg2webdriver.webapp;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesTests {

    @Test
    public void SeleccionandoCheckbox(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/webinar/projectg2-selenium-webdriver/webapp/checkboxestest.html");

        WebElement checkbox = driver.findElement(By.id("lettuceCheckbox"));

        checkbox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkbox.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
