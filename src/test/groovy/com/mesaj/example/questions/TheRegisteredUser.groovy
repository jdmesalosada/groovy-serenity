package com.mesaj.example.questions

import com.mesaj.example.model.registereduser.Datum
import com.mesaj.example.model.registereduser.RegisteredUser
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.rest.questions.RestQuestionBuilder

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight

class TheRegisteredUser {

    static Question<RegisteredUser> get() {
        return new RestQuestionBuilder<RegisteredUser>().about("registered users")
                .to("/api/users?page=2")
                .returning({ response -> response.body().as(RegisteredUser.class) })
    }

    static Datum randomUser() {
        return get().with { x ->
            def data = x.answeredBy(theActorInTheSpotlight()).data
            def size = data.size()
            def r = new Random()
            data.get(r.nextInt(size))
        }
    }
}
