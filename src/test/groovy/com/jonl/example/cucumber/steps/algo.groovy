package com.jonl.example.cucumber.steps

import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.rest.interactions.Post
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction
import serenity.PostJulian

import static cucumber.api.groovy.EN.Given

Actor actor

Given(~/^hello everybody$/) {
    ->
    actor = OnStage.theActorCalled("Julian the Administrator");

    def restQueryFunction = { request -> request.c }

    /*RequestSpecification info = { RequestSpecification requestSpecification ->
        requestSpecification
                .contentType(ContentType.JSON)
                .body "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}"
    }*/

    actor.attemptsTo(


          //  PostJulian.to("/api/users").

    )
}


