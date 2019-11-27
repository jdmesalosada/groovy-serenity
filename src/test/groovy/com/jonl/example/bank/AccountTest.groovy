package com.jonl.example.bank

import cucumber.api.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity)
@CucumberOptions(features = 'src/test/resources/features',
        glue = 'src/test/groovy/com/jonl/example/cucumber/steps')
class AccountTest {
}
