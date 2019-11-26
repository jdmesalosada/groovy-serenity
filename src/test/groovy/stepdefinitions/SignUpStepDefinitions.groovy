package stepdefinitions

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^Julian wants to create an account$/) { ->

}
When(~/^the account holder withdraws €(.+)$/) { double amount ->

}
Then(~/^the account balance will be €(.+)$/) { double expectedBalance ->

}