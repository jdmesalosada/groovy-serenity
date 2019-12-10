package com.mesaj.example.cucumber.steps

import com.mesaj.example.model.registereduser.Datum
import com.mesaj.example.questions.TheRegisteredUser
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.questions.TheValue
import net.serenitybdd.screenplay.rest.interactions.Get
import net.serenitybdd.screenplay.rest.questions.LastResponse
import org.apache.http.HttpStatus

import static cucumber.api.groovy.EN.*
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat
import static org.hamcrest.CoreMatchers.equalTo

Actor actor

Given(~/^Julian is a not registered user$/) {
    -> actor = OnStage.theActorCalled("Julian");
}

Given(~/^Julian is user a registered user$/) {
    -> actor = OnStage.theActorCalled("Julian");
}

Given(~/^Vane is an Agent$/) {
    -> actor = OnStage.theActorCalled("Vane");
}

When(~/^An agent searches for him with id (.*)$/) { int userId ->
    actor.attemptsTo(
            Get.resource("/api/users/" + userId)
    )
}

When(~/^she asks for a specific user of all the registered$/) { ->
    Datum randomRegisteredUser = TheRegisteredUser.randomUser()
    print(randomRegisteredUser)

    Question<Datum> randomUserQuestion = TheRegisteredUser.randomUserQuestion()
    Datum userRegisteredQuestion = randomUserQuestion.answeredBy(actor)

    Question<String> stringQuestion = TheRegisteredUser.stringToQuestion("hello")
    String normalString = stringQuestion.answeredBy(actor)
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

Then(~/^this should be fail$/) { ->
    actor.should(
            seeThat(
                    "response code", TheValue.of(LastResponse.received().answeredBy(actor).statusCode()),
                    equalTo(HttpStatus.SC_ACCEPTED)
            )
    )
}
