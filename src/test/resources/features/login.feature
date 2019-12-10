@api
Feature: Login

  @issue:FAX-1
  Scenario: Login with valid credentials
    Given Vane wants to login
    When she sends valid credentials
    Then she should have access to the application

  @issue:FAX-2
  Scenario: Login with invalid credentials
    Given Vane wants to login
    When she sends invalid credentials
    Then she should be told that their credentials are invalid

