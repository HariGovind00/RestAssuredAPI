package CucumberTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/CucumberFeatureFile/PostAPI.feature",
glue = "CucumberStepDefinationFile",
monochrome = true,
tags = "@AddPlaceAPI")
public class PostAPITestRunner extends AbstractTestNGCucumberTests
{

}
