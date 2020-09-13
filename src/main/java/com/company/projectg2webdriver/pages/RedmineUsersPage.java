package com.company.projectg2webdriver.pages;

import com.company.projectg2webdriver.models.RedmineUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RedmineUsersPage extends RedmineLoginPage {

    private By linkUsers = By.xpath("//a[@href='/users']");
    private By linkNewUsers = By.xpath("//*[@id='content']/div[1]/a");

    private By txtUserName = By.xpath("//*[@id='user_login']");
    private By txtFirstName = By.xpath("//*[@id='user_firstname']");
    private By txtLastName = By.xpath("//*[@id='user_lastname']");
    private By txtEmail = By.xpath("//*[@id='user_mail']");
    private By cbxLanguage = By.xpath("//*[@id='user_language']");
    private By chbxAdministrator = By.xpath("//*[@id='user_admin']");
    private By txtPassword = By.xpath("//*[@id='user_password']");
    private By txtPasswordConfirmation = By.xpath("//*[@id='user_password_confirmation']");

    private By btnCreateUser = By.xpath("//*[@id='new_user']/p/input[1]");

    private By lblUIMessage = By.xpath("//*[@id='flash_notice']");

    private By listUsers = By.tagName("table");

    public RedmineUsersPage(WebDriver driver) {
        super(driver);
    }

    public void createNewUser(RedmineUser user) {

        driver.findElement(txtUserName).sendKeys(user.getUserName());
        driver.findElement(txtFirstName).sendKeys(user.getFirstName());
        driver.findElement(txtLastName).sendKeys(user.getLastName());
        driver.findElement(txtEmail).sendKeys(user.getEmail());

        WebElement webElementSelectLanguage = driver.findElement(cbxLanguage);
        Select selectLanguage = new Select(webElementSelectLanguage);
        selectLanguage.selectByVisibleText(user.getLanguage());

        driver.findElement(chbxAdministrator).click();

        driver.findElement(txtPassword).sendKeys(user.getPassword());
        driver.findElement(txtPasswordConfirmation).sendKeys(user.getPassword());

        driver.findElement(btnCreateUser).click();

    }

    public String getUIMesageCreateUsers() {
        return driver.findElement(lblUIMessage).getText();
    }

    public Boolean userIsOnTheList(String userName) {

        List<WebElement> userList = driver.findElement(By.tagName("table"))
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        for (WebElement user : userList) {
            if (userName.equals(user.findElements(By.tagName("td")).get(0).getText()))
                return true;
        }
        return false;
    }

    public void clickOnLinkUsers() {
        driver.findElement(linkUsers).click();
    }

    public void clickOnLinkNewUsers() {
        driver.findElement(linkNewUsers).click();
    }

}
