package com.mesaj.example.cucumber.steps


import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.actions.Enter
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.actors.OnlineCast
import net.serenitybdd.screenplay.targets.Target
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import static cucumber.api.groovy.EN.*

Actor actor

WebDriver driver

Target USERNAME_FIELD = Target.the("Username textbox").locatedBy("#userName")
Target CURRENT_ADDRESS_FIELD = Target.the("Current address textbox").locatedBy("#currentAddress")
Target PERMANENT_ADDRESS_FIELD = Target.the("Permanent address textbox").locatedBy("#permanentAddress")
Target SUBMIT_BUTTON = Target.the("Submit textbox").locatedBy("#submit")

Given(~/^Julian is an user that wants to create a new account$/) {
    ->

    System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/windows/chromedriver.exe")
    //System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/mac/chromedriver")
    driver = new ChromeDriver()

    OnStage.setTheStage(
            OnlineCast.whereEveryoneCan(
                    BrowseTheWeb.with(driver)
            )
    )
    actor = OnStage.theActorCalled("Julian")

    //driver.manage().timeouts().implicitlyWait(30, TimeUn)
    driver.get("https://demoqa.com/keyboard-events-sample-form/")

}

When(~/^he sends the required information to sign up$/) {
    ->
    actor.attemptsTo(
            Enter.theValue("Julian Cho")
                    .into(USERNAME_FIELD),
            Enter.theValue("Francuska 456")
                    .into(CURRENT_ADDRESS_FIELD),
            Enter.theValue("Chorzowska 100")
                    .into(PERMANENT_ADDRESS_FIELD),
            Click.on(SUBMIT_BUTTON),
    )
}

Then(~/^he should be told that the account was created$/) {
    ->
    driver.quit()
}
