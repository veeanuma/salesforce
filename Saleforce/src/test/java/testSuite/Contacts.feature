#Author: veereshanumadla@gmail.com
@Contacts
Feature: Check the Contact and Delete

  Scenario: Launch Salesforce site and Login
    Given User Salesforce Dashboard Page
    When 	click on Contacts
    Then  Recently Viewed Contacts Page will appear
    And 	Cross check Lead which is Lead Converted As Contact Appear or Not 
    When  Click on Triangle for Options
    Then  Options Will Display
    When  click Delete Option 
    Then  Agains Asks Delete Contact Confirmation
    When  Click on Delete btn
    Then  Contact Deleted status will Appear
    
    