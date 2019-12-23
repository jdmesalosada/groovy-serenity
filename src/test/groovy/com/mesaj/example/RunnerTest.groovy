package com.mesaj.example

import cucumber.api.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity)
@CucumberOptions(
        plugin = ['pretty',
                'json:target/reports/json/MainTestReport.json',
                'html:target/reports/html/MainTestReport',
                'junit:target/reports/junit/MainTestReport.xml'],
        features = 'src/test/resources/features',
        glue = 'src/test/groovy/com/mesaj/example/cucumber/steps')
//Runner name should contain "Test" word
class RunnerTest {
}
