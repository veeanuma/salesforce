#Author: veereshanumadla@gmail.com
@Leads
Feature: Create a new Lead,Update Lead and validate functionality
    
    @regressiontest
  Scenario: Import Lead from csv File
    Given User is on salesforce Dashboard Page
    When Click on leads link
    Then Page will navigates to Leads Pages
    And click Import link
    Then it naviagtes to Import your Data into Salesforce page
    When Click on Standard object leads
    Then progress marker shows Good job
    When Click on add  new records
    Then progress marker shows Good job
    When Click on add  CSV file to upload
    Then CSV file selector box will open
    When Click on choose file
    Then Open window dialouge opens
    When Send valid file path to that textbox
    And click on open button
    And click Next button
    Then progress marker shows Almost done
    When click Next button
    Then progress marker shows Great job
    When click start import button
    Then page shows like Congratulations, your import has started
    When click ok button
    Then Page will navigates to Leads Pages

