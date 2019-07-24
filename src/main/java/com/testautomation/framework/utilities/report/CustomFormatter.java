package com.testautomation.framework.utilities.report;

import cucumber.runtime.StepDefinitionMatch;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;

public class CustomFormatter implements Reporter {
    public  CustomFormatter() { }

    @Override
    public void before(Match match, Result result) {}

    @Override
    public void result(Result result) {}

    @Override
    public void after(Match match, Result result) {}

    @Override
    public void match(Match match) {
        ThreadLocalStepDefinitionMatch.set((StepDefinitionMatch)match);
    }

    @Override
    public void embedding(String mimeType, byte[] data) {}

    @Override
    public void write(String text) {}
}
