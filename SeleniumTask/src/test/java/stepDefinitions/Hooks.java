package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
TestContextSetup testContextSetup;
	//implemetn preconditions and post conditions.
//injecting the testcontext setup
	public Hooks(TestContextSetup testContextSetup)
	{
		
		this.testContextSetup = testContextSetup;
	}
	@After
	public void AfterScenario() throws IOException
	{
		
		testContextSetup.testBase.WebDriverManager().quit();
		
	}
	


	
}
