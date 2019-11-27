package com.jonl.example.cucumber.steps

import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.actors.OnlineCast
import net.serenitybdd.screenplay.rest.abilities.CallAnApi

import static cucumber.api.groovy.Hooks.Before

Before() {
    OnStage.setTheStage(
            /*You can also use the whereEveryoneCan method to provide additional abilities, e.g.
            This will provide actors who can both use WebDriver starter.tasks and RestAssured starter.tasks.
            Reference: https://serenity-bdd.github.io/theserenitybook/latest/screenplay-selenium-tasks.html
             */
            OnlineCast.whereEveryoneCan(
                    CallAnApi.at("http://localhost:5000")
            )
    )
    print("Setting the stage")
}