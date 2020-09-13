package com.company.projectg2webdriver.redmine;

import com.company.projectg2webdriver.base.BaseTest;
import com.company.projectg2webdriver.models.RedmineProject;
import com.company.projectg2webdriver.pages.RedmineHomePage;
import com.company.projectg2webdriver.pages.RedmineProjectsPage;
import org.junit.Assert;
import org.junit.Test;

public class RedmineProjectTest extends BaseTest {

    @Test
    public void testCreateProjectRedmine(){

        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        RedmineProjectsPage redmineProjectsPage = (RedmineProjectsPage) redmineHomePage.clickOnLink("projects");

        redmineProjectsPage.clickNewProject();

        RedmineProject redmineProject = new RedmineProject();
        redmineProject.setName("RedmineProjectName7");
        redmineProject.setDescription("Esta es una descripción de una prueba automatizada");
        redmineProject.setHomePage("RedmineProjectHomePage");
        redmineProject.setPublic(true);


        redmineProjectsPage.createProject(redmineProject);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("Successful creation.", redmineProjectsPage.getUIMessage());
    }
}