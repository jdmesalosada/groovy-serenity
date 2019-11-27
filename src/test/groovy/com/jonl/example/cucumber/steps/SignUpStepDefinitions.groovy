package com.jonl.example.cucumber.steps

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.rest.abilities.CallAnApi
import net.serenitybdd.screenplay.rest.interactions.Get
import net.serenitybdd.screenplay.rest.questions.LastResponse
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat


def actor = Actor.named("Julian")

Given(~/^Julian is a new user in the bank$/) {
    -> actor.can(CallAnApi.at("http://localhost:5000"))
}

When(~/^he send the required information$/) { ->
    actor.attemptsTo(
            Get.resource("/api/users/23")
    )
}

Then(~/^he should get a virtual account to manage their products$/) { ->

   // TheValue.of()
  /*  actor.should(
            seeThat(
                    "el codigo de respuesta", TheValue.of(LastResponse.received().answeredBy(actor).statusCode()),
                    equalTo(201)
            )
    )*/
}