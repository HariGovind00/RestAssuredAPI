package CucumberTestRunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/CucumberFeatureFile/AddMapAddress.feature",
glue = "CucumberStepDefinationFile",
monochrome = true,
tags = "@AddPlace")

public class LibraryAPITestRunnerClass extends AbstractTestNGCucumberTests
{
	
}
