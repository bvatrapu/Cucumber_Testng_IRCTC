package com.IRCTC.cucumber.steps;

import com.testautomation.framework.utilities.report.ThreadLocalStepDefinitionMatch;
import cucumber.runtime.StepDefinitionMatch;

public class StepManager {

    StepDefinitionMatch scenario;

    public String getStepName(){
        scenario = ThreadLocalStepDefinitionMatch.get();
        return scenario.getStepName();

    }

    public String getPattern(){
        scenario = ThreadLocalStepDefinitionMatch.get();
        return scenario.getPattern();
    }


}
