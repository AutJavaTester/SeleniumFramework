package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


@RunWith(Cucumber.class)
@CucumberOptions (features   = "src\\test\\java\\features\\UserRegistration.feature",
   glue  = {"steps"},
   plugin  = {"pretty , html : target/cucumber-html-report"}) 
public class TestRunner extends TestBase {
	
}
