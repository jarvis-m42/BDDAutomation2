@UATTesting
Feature: GetCarnera homepage validations

  Scenario Outline: GetCarnera homepage positive scenarios
    Given I open 'carnera' application
    Then I see text 'Contact Us' is visible
    And I click on contact us button
    Then I fill form with "<name>","<lastName>","<email>","<about>","<time>"

Examples:
    |name|lastName|email|about|time|
    | Rohit   | Bhosale       |  rt@gmail.com   |  Testing   |   anyday |