@web
Feature: Users sign up

  Scenario: User sign up successfully
    Given Julian is an user that wants to create a new account
    When he sends the required information to sign up
    Then he should be told that the account was created