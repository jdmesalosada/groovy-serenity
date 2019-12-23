# groovy-serenity

References: <br>
- https://github.com/JonLally/cucumber-groovy-tutorial <br>
- https://github.com/serenity-bdd/serenity-core/blob/master/serenity-screenplay-webdriver/src/test/groovy/net/serenitybdd/screenplay/actors/WhenDefiningAnOnlineCast.groovy
- https://github.com/serenity-bdd/screenplay-pattern-todomvc
- https://github.com/serenity-bdd/bdd-trader
- https://codoid.com/how-to-integrate-jira-with-serenity-bdd/

# Run tests
- mvn test

# Generate report
- mvn serenity:aggregate

# Run and generate report
- mvn verify

# Run web scenarios
- mvn verify -Dcucumber.options="--tags '@web'"
- mvn verify -Dcucumber.options="--tags '@api'"

# Report Sample

https://jdmesalosada.github.io/groovy-serenity/



# JIRA DOCKER
- docker volume create --name jiraVolume
- docker run -v jiraVolume:/var/atlassian/application-data/jira --name="jira" -d -p 8081:8080 atlassian/jira-software
- http://localhost:8081/secure/Dashboard.jspa

# ZAPI
{
  "cycleId": "-1",
  "issueId": "10001", // el id del test case en jira. Toca ejecutar un query en jira para obtener todos los ids del proyecto
  "projectId": "10000",
  "versionId": "Unscheduled",
  "assigneeType": "assignee",
  "assignee": "apostol",
  "folderId": 1 //toca crear el folder usando el recurso.
}

Get Jira issues:

http://localhost:8081/rest/api/2/search?jql=project=FAX