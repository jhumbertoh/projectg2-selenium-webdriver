package com.company.projectg2webdriver.cucumber;

import com.company.projectg2webdriver.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@e2e")
    public static void setUp(){
        BaseTest.setUp();
    }

    @After("@e2e")
    public static void tearDown(){
        BaseTest.tearDown();
    }
}