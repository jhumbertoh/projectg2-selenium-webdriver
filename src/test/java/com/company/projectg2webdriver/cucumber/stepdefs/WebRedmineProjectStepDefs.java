package com.company.projectg2webdriver.cucumber.stepdefs;

import com.company.projectg2webdriver.models.RedmineProject;
import com.company.projectg2webdriver.pages.RedmineHomePage;
import com.company.projectg2webdriver.pages.RedmineProjectsPage;
import com.company.projectg2webdriver.util.Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebRedmineProjectStepDefs {

    BaseStepDefs baseStepDefs;
    RedmineProjectsPage redmineProjectsPage;

    public WebRedmineProjectStepDefs(BaseStepDefs baseStepDefs) {
        this.baseStepDefs = baseStepDefs;
    }


    @When("I create a project")
    public void iCreateAProject(Map<String, String> projectData) {

        RedmineHomePage redmineHomePage = (RedmineHomePage) baseStepDefs.currentPage;
        redmineProjectsPage = (RedmineProjectsPage) redmineHomePage.clickOnLink("Projects");

        String number = Util.generateRandomNumber();

        RedmineProject redmineProject = new RedmineProject();
        redmineProject.setName(projectData.get("name") + number);
        redmineProject.setDescription(projectData.get("description") + number);
        redmineProject.setHomePage(projectData.get("homepage") + number);
        redmineProject.setPublic(Boolean.parseBoolean(projectData.get("public")));


        redmineProjectsPage.clickNewProject();

        redmineProjectsPage.createProject(redmineProject);

    }


    @Then("The project was successfully created")
    public void theProjectWasSuccessfullyCreated() {

        Assert.assertEquals("Successful creation.", redmineProjectsPage.getUIMessage());
    }
}
