package com.mesaj.example.cucumber.steps

import com.mesaj.example.tasks.DoLogin
import net.serenitybdd.rest.Ensure
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.actors.OnStage
import org.apache.http.HttpStatus

import static cucumber.api.groovy.EN.*
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat
import static org.hamcrest.CoreMatchers.*

Actor actor

Given(~/^Vane wants to login$/) {
    ->
    actor = OnStage.theActorCalled("Vane the user")
}

Given(~/^I failed$/) {
    ->
    actor = OnStage.theActorCalled("Vane the user")

    Question<String> actualValue = Question.about("string that want a be a question string").answeredBy(
            { a -> "actual" })

    actor.should(
            seeThat("The value is", actualValue, equalTo("expected"))
    )
}

When(~/^she sends invalid credentials$/) { ->
    actor.attemptsTo(
            DoLogin.with("{\n" +
                    "    \"email\": \"peter@klaven\"\n" +
                    "}")
    )
}

When(~/^she sends valid credentials$/) { ->
    actor.attemptsTo(
            DoLogin.with("{\n" +
                    "    \"email\": \"eve.holt@reqres.in\",\n" +
                    "    \"password\": \"cityslicka\"\n" +
                    "}")
    )
}

Then(~/^she should be told that their credentials are invalid$/) { ->
    Ensure.that("response code is 400", { response -> response.statusCode(HttpStatus.SC_BAD_REQUEST) })
}

Then(~/^she should have access to the application$/) { ->
    Ensure.that("response code is 200", { response -> response.statusCode(HttpStatus.SC_OK) })
            .andThat("token is not null", { response -> response.body("token", not(nullValue())) })
}



