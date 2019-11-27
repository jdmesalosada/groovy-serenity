package com.jonl.example.cucumber.steps

import com.jonl.example.bank.Account
import cucumber.api.PendingException

// Add functions to register hooks and steps to this script.
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Define a world that represents the test environment.
// Hooks can set up and tear down the environment and steps
// can change its state, e.g. store values used by later steps.
class TestBank {
    def account
}

// Create a fresh new world object as the test environment for each scenario.
// Hooks and steps will belong to this object so can access its properties
// and methods directly.
World {
    new TestBank()
}

// This closure gets run before each scenario
// and has direct access to the new world object
// but can also make use of script variables.
Before() {
    account = new Account('John Doe', 2319.85, new Date(2000, 1, 1))
}

// Register another that also gets run before each scenario tagged with @notused.
Before("@joeBloggsAccount") {
    account = new Account('Joe Bloggs', 2256.85, new Date(2005, 1, 1))
}

// Register another that also gets run before each scenario tagged with
// (@notused or @important) and @alsonotused.
Before("@notused,@important", "@alsonotused") {
    throw new RuntimeException("Never happens")
}

// Register step definition using Groovy syntax for regex patterns.
// If you use slashes to quote your regexes, you don't have to escape backslashes.
// Any Given/When/Then function can be used, the name is just to indicate the kind of step.

Given(~/^the account exists$/) { ->
    assert account
}
When(~/^the account holder withdraws €(.+)$/) { double amount ->
    account.withdraw amount
}
Then(~/^the account balance will be €(.+)$/) { double expectedBalance ->
    assert account.balance == expectedBalance
}