#Author: veereshanumadla@gmail.com
@Login
Feature: validate Login functionality

  Scenario: Launch Salesforce site and Login
    Given User is on salesforce Login Page
    And Enter userid 
    And Enter password
    When click Login
    Then Home Page is displayed