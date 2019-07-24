package com.IRCTC.cucumber.runner;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Hook {

    @Before
    public void startUp(Scenario scenario) {
        //configTestData.testMethodName = scenario.getName();
        System.out.println("scenario name:: "+scenario.getName());
    }
}
