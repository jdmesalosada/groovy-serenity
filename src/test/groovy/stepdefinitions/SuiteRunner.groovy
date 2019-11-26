package stepdefinitions


import cucumber.api.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity)
@CucumberOptions(
        plugin = ["pretty", "html:target/site/cucumber"],
        features = "src/test/resources/features"
)
class SuiteRunner {
}
