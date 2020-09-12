package com.company.projectg2webdriver.cucumber.stepdefs;

import com.company.projectg2webdriver.base.BaseTest;
import com.company.projectg2webdriver.pages.RedmineLoginPage;

public class BaseStepDefs {

    protected RedmineLoginPage currentPage;

    public BaseStepDefs(){
        currentPage = new RedmineLoginPage(BaseTest.getDriver());
    }
}
