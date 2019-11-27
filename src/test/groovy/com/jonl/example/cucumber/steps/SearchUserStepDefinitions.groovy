package com.jonl.example.cucumber.steps

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.questions.TheValue
import net.serenitybdd.screenplay.rest.abilities.CallAnApi
import net.serenitybdd.screenplay.rest.interactions.Get
import net.serenitybdd.screenplay.rest.questions.LastResponse
import org.apache.http.HttpStatus

import static cucumber.api.groovy.EN.*
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat
import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

//import net.serenitybdd.screenplay.questions.ValueOf;

def actor = Actor.named("Julian")

Given(~/^Julian is a new user in the bank$/) {
    -> actor.can(CallAnApi.at("http://localhost:5000"))
}

Given(~/^Julian is user not registered$/) {
    -> actor.can(CallAnApi.at("http://localhost:5000"))
}

When(~/^An agent searches for him with id (.*)$/) { int userId ->

    actor.attemptsTo(
            Get.resource("/api/users/" + userId)
    )
}

Then(~/^he should get a virtual account to manage their products$/) { ->
    /*  assertThat("The response code is the expected",
              SerenityRest.lastResponse().statusCode(), equalTo(HttpStatus.SC_OK))*/
    actor.should(
            seeThat(
                    "response code", TheValue.of(LastResponse.received().answeredBy(actor).statusCode()),
                    equalTo(HttpStatus.SC_CREATED)
            )
    )
}

Then(~/^he should be told that the user doesn't exist$/) { ->
    actor.should(
            seeThat(
                    "response code", TheValue.of(LastResponse.received().answeredBy(actor).statusCode()),
                    equalTo(HttpStatus.SC_NOT_FOUND)
            )
    )
}

Then(~/^he should be told that the user exists$/) { ->
    actor.should(
            seeThat(
                    "response code", TheValue.of(LastResponse.received().answeredBy(actor).statusCode()),
                    equalTo(HttpStatus.SC_OK)
            )
    )
}

