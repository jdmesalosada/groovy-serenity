package com.jonl.example.cucumber.steps

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When

Given(~/^Julian is a new user in the bank$/) {
    -> print("hello world")
}

When(~/^he send the required information$/) { ->
}


Then(~/^he should get a virtual account to manage their products$/) { ->
    assert true == true
}