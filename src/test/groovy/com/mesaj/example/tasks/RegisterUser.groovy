package com.mesaj.example.tasks


import com.mesaj.example.model.User
import io.restassured.http.ContentType
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.rest.interactions.Post
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction
import static net.serenitybdd.screenplay.Tasks.instrumented;

class RegisterUser implements Task {

    final User userToRegister

    RegisterUser(User userToRegister) {
        this.userToRegister = userToRegister
    }

    static def withInfo(User user) {
        return instrumented(RegisterUser.class, user)
    }

    @Override
    <T extends Actor> void performAs(T actor) {

        RestQueryFunction requestInfo = { request ->
            request.body(userToRegister)
                    .contentType(ContentType.JSON)
        }

        actor.attemptsTo(
                Post.to("/api/register").with(requestInfo)
        )
    }
}
