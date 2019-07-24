/**
 *
 *	
 *	14-Aug-2016
 */
package com.IRCTC.cucumber.runner.desktop;

import com.IRCTC.base.TestBase;
import cucumber.api.CucumberOptions;

@CucumberOptions(features = { "classpath:features/IRCTC/Desktop/HomePage.feature" },
		glue = {"classpath:com.IRCTC.cucumber.steps"},
		plugin = {"pretty","html:report", "json:reports.json",
				"rerun:target/rerun.txt", "com.testautomation.framework.utilities.report.CustomFormatter","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },

		tags = {"@Regression"})

public class HomeFeatureRunner extends TestBase {

}
