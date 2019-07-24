/**
 *
 *	
 *	14-Aug-2016
 */
package com.IRCTC.cucumber.runner.mobile;

import com.IRCTC.base.TestBase;
import cucumber.api.CucumberOptions;

@CucumberOptions(features = { "classpath:features/IRCTC/mobile/HomeScreen.feature" },
		glue = {"classpath:com.Albertsons.cucumber.steps"},
		plugin = { "pretty", "html:target/cucumber" },
		tags = {"@Regression"})
public class HomeScreenFeatureRunner extends TestBase {

}
