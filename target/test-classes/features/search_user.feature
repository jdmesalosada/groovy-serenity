@api
Feature: Search users

  Scenario: search user that doesn't exist
    Given Julian is a not registered user
    When An agent searches for him with id 123
    Then he should be told that the user doesn't exist

  Scenario: search user for user that is registered
    Given Julian is user a registered user
    When An agent searches for him with id 2
    Then he should be told that the user exists

  Scenario: search user for user that is registered - failed test
    Given Julian is user a registered user
    When An agent searches for him with id 2
    Then this should be fail