package com.company.projectg2webdriver.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesTests {

    @Test
    public void gettingTableData(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/webinar/projectg2-selenium-webdriver/webapp/tabletest.html");

        WebElement tablaExterna = driver.findElement(By.tagName("table"));
        WebElement tablaInterna = tablaExterna.findElement(By.tagName("table"));
        WebElement fila = tablaInterna.findElements(By.tagName("td")).get(1);

        // Otra forma de identificar el elemento
        //WebElement fila2 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));

        System.out.println(fila.getText());

        Assert.assertEquals("Table 2 Row 2", fila.getText());

        driver.quit();
    }
}
