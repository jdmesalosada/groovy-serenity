package com.jonl.example.cucumber.steps

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.actors.OnlineCast
import net.serenitybdd.screenplay.rest.abilities.CallAnApi
import org.openqa.selenium.WebDriver

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.When
import static cucumber.api.groovy.EN.Then

Actor actor

WebDriver driver

Given(~/^Julian is an user that wants to create a new account$/) {
    ->

    OnStage.setTheStage(
            OnlineCast.whereEveryoneCan(
                    BrowseTheWeb.with()
            )
    )
    actor = OnStage.theActorCalled("Julian");

}

When(~/^he sends the required information to sign up$/) {
    -> actor = OnStage.theActorCalled("Julian");

}

Then(~/^he should be told that the account was created$/) {
    -> actor = OnStage.theActorCalled("Julian");
}
