# groovy-serenity

References: <br>
- https://github.com/JonLally/cucumber-groovy-tutorial <br>
- https://github.com/serenity-bdd/serenity-core/blob/master/serenity-screenplay-webdriver/src/test/groovy/net/serenitybdd/screenplay/actors/WhenDefiningAnOnlineCast.groovy
- https://github.com/serenity-bdd/screenplay-pattern-todomvc
- https://github.com/serenity-bdd/bdd-trader

# Run tests
- mvn test

# Generate report
- mvn serenity:aggregate

# Run and generate report
- mvn verify

# Run web scenarios
- mvn verify -Dcucumber.options="--tags '@web'"
- mvn verify -Dcucumber.options="--tags '@api'"



# JIRA DOCKER
- docker volume create --name jiraVolume
- docker run -v jiraVolume:/var/atlassian/application-data/jira --name="jira" -d -p 8081:8080 atlassian/jira-software
- http://localhost:8081/secure/Dashboard.jspa