package orangehr.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/orangehr/features" }, glue = { "orangehr.stepdefinitions",
		"orangehr.apphooks" }, monochrome = true, plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "not @login")

public class TestRunner {

}
