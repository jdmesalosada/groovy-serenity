package com.mesaj.example.tasks

import com.mesaj.example.model.User
import io.restassured.http.ContentType
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.rest.interactions.Post
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction

import static net.serenitybdd.screenplay.Tasks.instrumented

class DoLogin implements Task {

    final String credentials

    DoLogin(String credentials) {
        this.credentials = credentials
    }

    static def with(String credentials) {
        return instrumented(DoLogin.class, credentials)
    }

    @Override
    <T extends Actor> void performAs(T actor) {
        RestQueryFunction credentials = { request ->
            request.body(credentials).contentType(ContentType.JSON)
        }

        actor.attemptsTo(
                Post.to("/api/login").with(credentials)
        )
    }
}
