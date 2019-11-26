


import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

//@RunWith(CucumberWithSerenity)
@RunWith(Cucumber)
@CucumberOptions(
        plugin = ["pretty", "html:target/site/cucumber"],
        features = "src/test/resources/features"
)
class SuiteRunner {
}
