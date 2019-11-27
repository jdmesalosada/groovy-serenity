Feature: Sign up

  Scenario: user sign up successfully
    Given Julian is a new user in the bank
    When he send the required information
    Then he should get a virtual account to manage their products