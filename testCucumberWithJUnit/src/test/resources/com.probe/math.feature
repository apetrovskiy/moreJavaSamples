Feature: Maths

  Background:
    Given first number is 5

  Scenario: Adding a number
    When I add 2
    Then the result is 7

  Scenario: Substracting a number
    When I substract 2
    Then the result is 3

  Scenario: Multiplying by a number
    When I multiply by 2
    Then the result is 10