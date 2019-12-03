package com.jonl.example.cucumber.steps

import net.serenitybdd.rest.Ensure
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.actors.OnStage
import org.apache.http.HttpStatus
import tasks.CreateUser

import static cucumber.api.groovy.EN.*
import static org.hamcrest.CoreMatchers.equalTo

Actor actor

Given(~/^Julian is the Administrator$/) {
    -> actor = OnStage.theActorCalled("Julian the Administrator");
}

When(~/^he sends the information required to create an user$/) {
    ->
    actor.attemptsTo(
            CreateUser.withInfo("{\n" +
                    "    \"name\": \"morpheus\",\n" +
                    "    \"job\": \"leader\"\n" +
                    "}")
    )
}

Then(~/^he should see the user was created successfully$/) {
    ->
    Ensure.that("response code is 201", { response -> response.statusCode(HttpStatus.SC_CREATED) })
            .andThat("user name is morpheus", { response -> response.body("name", equalTo("morpheus")) })
            .andThat("job is leader", { response -> response.body("job", equalTo("leader")) })
}
