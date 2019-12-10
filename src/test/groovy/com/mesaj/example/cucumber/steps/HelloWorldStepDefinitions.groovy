package com.mesaj.example.cucumber.steps

import com.mesaj.example.model.User
import com.mesaj.example.tasks.RegisterUser
import io.restassured.http.ContentType
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.rest.interactions.Post
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.When

Actor actor

Given(~/^hello everybody$/) {
    ->
    actor = OnStage.theActorCalled("Julian the Administrator");

    RestQueryFunction userInformation = { request ->
        request.body("{\n" +
                "    \"name\": \"julian\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").contentType(ContentType.JSON)
    }

    actor.attemptsTo(
            Post.to("/api/users").with(userInformation)
    )
}


Given(~/^Scarlett want to register$/) { ->
}

When(~/^she sends the required information to get an account$/) { ->

    User user = new User()
    user.email = "julian.cho@gmail.com"
    user.password = "powerfullpassnotbodyknows"

    actor.attemptsTo(
            RegisterUser.withInfo(user)
    )
}



