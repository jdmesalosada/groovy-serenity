package com.jonl.example.cucumber.steps


import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actions.Enter
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.actors.OnlineCast
import net.serenitybdd.screenplay.targets.Target
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When


Actor actor

WebDriver driver


Given(~/^Julian is an user that wants to create a new account$/) {
    ->

    // System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/windows/chromedriver.exe")
    System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/mac/chromedriver")
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

    Target USERNAME_FIELD = Target.the("New Todo Field").locatedBy("#userName")
    actor.attemptsTo(
            Enter.theValue("Julian Cho")
                    .into(USERNAME_FIELD),
    )
}

Then(~/^he should be told that the account was created$/) {
    ->
    driver.quit()
}
