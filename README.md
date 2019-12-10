# groovy-serenity

References: <br>
- https://github.com/JonLally/cucumber-groovy-tutorial <br>
- https://github.com/serenity-bdd/serenity-core/blob/master/serenity-screenplay-webdriver/src/test/groovy/net/serenitybdd/screenplay/actors/WhenDefiningAnOnlineCast.groovy
- https://github.com/serenity-bdd/screenplay-pattern-todomvc
- https://github.com/serenity-bdd/bdd-trader

# Run tests
mvn test

# Generate report
mvn serenity:aggregate

# Run and generate report
mvn verify

# Run web scenarios
mvn verify -Dcucumber.options="--tags '@web'"
mvn verify -Dcucumber.options="--tags '@api'"



