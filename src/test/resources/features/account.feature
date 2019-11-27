Feature: Bank Account feature

  @joeBloggsAccount
  Scenario: creating account saves the correct information
    Given the account exists
    When the account holder withdraws €300.00
    Then the account balance will be €1956.85