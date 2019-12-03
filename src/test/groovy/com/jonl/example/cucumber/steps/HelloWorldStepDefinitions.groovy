package com.jonl.example.cucumber.steps

import io.restassured.http.ContentType
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.rest.interactions.Post
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction

import static cucumber.api.groovy.EN.Given

Actor actor

Given(~/^hello everybody$/) {
    ->
    actor = OnStage.theActorCalled("Julian the Administrator");

    RestQueryFunction restQueryFunction = { request ->
        request.body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").contentType(ContentType.JSON)
    }

    actor.attemptsTo(
            Post.to("/api/users").with(restQueryFunction)
    )
}


