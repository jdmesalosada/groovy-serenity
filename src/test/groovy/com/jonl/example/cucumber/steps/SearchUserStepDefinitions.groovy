package com.jonl.example.cucumber.steps

import net.serenitybdd.rest.SerenityRest
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.rest.abilities.CallAnApi
import net.serenitybdd.screenplay.rest.interactions.Get
import org.apache.http.HttpStatus

import static cucumber.api.groovy.EN.*
import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

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
    assertThat("The response code is the expected",
            SerenityRest.lastResponse().statusCode(), equalTo(HttpStatus.SC_OK))

    //Search how to use TheValue.of
    // TheValue.of()
    /*  actor.should(
              seeThat(
                      "el codigo de respuesta", TheValue.of(LastResponse.received().answeredBy(actor).statusCode()),
                      equalTo(201)
              )
      )*/
}

Then(~/^he should be told that the user doesn't exist$/) { ->
    assertThat("The response code is the expected",
            SerenityRest.lastResponse().statusCode(), equalTo(HttpStatus.SC_NOT_FOUND))
}

Then(~/^he should be told that the user exists$/) { ->
    assertThat("The response code is the expected",
            SerenityRest.lastResponse().statusCode(), equalTo(HttpStatus.SC_OK))
}

