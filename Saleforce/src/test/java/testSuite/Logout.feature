#Author: veereshanumadla@gmail.com
@Logout
Feature: validate Logout functionality
Scenario: Logout from Sales from Dashboard
    Given User Salesforce Dashboard Page
    And click on Profile Pic
    When click on Logout btn
    Then Login Page is displayed
