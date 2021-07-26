#Author: veereshanumadla@gmail.com
@Leads
Feature: Create a new Lead,Update Lead and validate functionality

@regressiontest
  Scenario Outline: WebtoLead
    Given User is on salesforce Dashboard Page
    When Navigate to url
    Then webtoLead form Should be displayed
    And Fill Form"<firstName>","<lastname>","<salutation>","<phone>","<email>","<city>","<state>","<Company>"
    When Click on Submit button
    Then its automatically Navigate to salesforce.com

    Examples: 
      | salutation | firstName | lastname  | email           | phone      | city     | state     | Company |
      | Mr.        | Sreenu    | Anuamndla | veeru@gmail.com | 9553109052 | Warangal | Telangana | IBM     |


   @regressiontest
  Scenario: get  picklist data using Object Manager
    Given User is on salesforce Dashboard Page
    When Click on setup Gear Symbol
    And click on Setup button
    Then it should be navigates to Setup home page
    When Click on Object Manager
    Then its opens New tab with Object Manager Title
    When Click on Module which we want to test
    Then its displays  Module details  and with Title of module name
    When Click on fields and relationships
    Then all items in Module will appear here
    When Click on Required item
    Then it will opens with picklist values
    And Read table of list of item values
    And close the tab and move to salesforce Dashboard Page open new lead form
    And Read List from Form
    And Compare both Lists After Sort
