@api
Feature: Create Users

  Scenario: create users
    Given Julian is the Administrator
    When he sends the information required to create an user
    Then he should see the user was created successfully