package com.company.projectg2webdriver.redmine;

import com.company.projectg2webdriver.base.BaseTest;
import com.company.projectg2webdriver.pages.RedmineHomePage;
import com.company.projectg2webdriver.pages.RedmineLoginPage;
import org.junit.Assert;
import org.junit.Test;

public class RedmineLoginTest extends BaseTest {

    @Test
    public void testLoginRedmine(){

        String user = "user", password = "bitnami1";
        String userExpected = "Logged in as user";


        RedmineHomePage redmineHomePage = redmineLoginPage.login(user,password);

        String userActual = redmineHomePage.getUserLogged();

        Assert.assertEquals(userExpected, userActual);
    }

}
