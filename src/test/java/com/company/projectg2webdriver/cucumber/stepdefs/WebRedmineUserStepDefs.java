package com.company.projectg2webdriver.cucumber.stepdefs;

import com.company.projectg2webdriver.models.RedmineUser;
import com.company.projectg2webdriver.pages.RedmineHomePage;
import com.company.projectg2webdriver.pages.RedmineUsersPage;
import com.company.projectg2webdriver.util.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebRedmineUserStepDefs {

    BaseStepDefs baseStepDefs;
    RedmineUsersPage redmineUsersPage;
    RedmineUser redmineUser;

    public WebRedmineUserStepDefs(BaseStepDefs baseStepDefs) {
        this.baseStepDefs = baseStepDefs;
    }


    @When("I create a user")
    public void iCreateAUser(Map<String, String> userData) {

        RedmineHomePage redmineHomePage = (RedmineHomePage) baseStepDefs.currentPage;
        redmineUsersPage = (RedmineUsersPage) redmineHomePage.clickOnLink("Administration");

        String number = Util.generateRandomNumber();

        redmineUser = new RedmineUser();
        redmineUser.setUserName(userData.get("userName") + number);
        redmineUser.setFirstName(userData.get("firstName") + number);
        redmineUser.setLastName(userData.get("lastName") + number);
        redmineUser.setEmail(redmineUser.getUserName() + userData.get("email"));
        redmineUser.setLanguage(userData.get("language"));
        redmineUser.setAdministrator(Boolean.parseBoolean(userData.get("administrator")));
        redmineUser.setPassword(userData.get("password"));

        redmineUsersPage.clickOnLinkUsers();
        redmineUsersPage.clickOnLinkNewUsers();

        redmineUsersPage.createNewUser(redmineUser);
    }

    @Then("The user was successfully created")
    public void theUserWasSuccessfullyCreated() {

        Assert.assertEquals("User " + redmineUser.getUserName() + " created.", redmineUsersPage.getUIMesageCreateUsers());
    }

    @And("The User should be available in User list")
    public void theUserShouldBeAvailableInUserList() {

        redmineUsersPage.clickOnLinkUsers();
        Assert.assertTrue(redmineUsersPage.userIsOnTheList(redmineUser.getUserName()));
    }
}
