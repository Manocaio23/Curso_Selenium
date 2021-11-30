package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/Cadastro_Campo.feature",
		glue = {"Steps"},
		dryRun = false,
		monochrome = true,
		tags = "",
		plugin = {"pretty", "html:target/cucumber-report.html"})
public class Runner {
	
}
