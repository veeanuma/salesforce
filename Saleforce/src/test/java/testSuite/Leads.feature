#Author: veereshanumadla@gmail.com
@Leads
Feature: Create a new Lead,Update Lead and validate functionality

Scenario: Click New Lead
    Given User is on salesforce Dashboard Page
    When Click Lead Object and click new Lead
    Then Lead form Should be displayed


  Scenario Outline: Save Lead  by filling the form
    Given User is on load form page
    And enter firstName as "<firstName>" middleName as "<middleName>" lastname as "<lastname>"  salutation as "<salutation>" Website as "<Website>" suffix as "<suffix>" Company  as "<Company>" Email as "<Email>" MobilePhone as "<MobilePhone>" industry as "<industry>" Leadsource as "<Leadsource>"    details to fill
    When click save
    Then find and verify Lead and click that saved lead

    Examples: 
      | firstName | middleName | lastname  | salutation | Website         | suffix | Company | Email                      | MobilePhone | industry | Leadsource |
      | Veeresh   | Sathya     | Anumandla | Mr.        | rampwave.org.in | jr     | IBM     | veereshanumandla@gmail.com |  9666116845 | Banking  | Website    |

  Scenario Outline: Edit Lead Data and Check
    Given User is on   Present Saved Lead Deatils Page
    And click on Edit
    And change Phone Number as per "<New_Mobile_Number>"
    When Click Save_Btn
    Then mobile number upadted
    Then find and verify Lead and click that saved lead

    Examples: 
      | New_Mobile_Number |
      |        8919188076 |

  Scenario Outline: Move Lead to contact
    Given User is on   Present Saved Lead Deatils Page
    And clickchatter
    And Share on Update about lead "<Update1>"
    And Click on MarkStatus
    And clickchatter
    And Share on Update about lead "<Update2>"
    And Click on MarkStatus
    And clickchatter
    And Share on Update about lead "<Update3>"
    And Click on MarkStatus
    Then Convert Lead form Will displayed
    And Click on Convert Btn
    When Click on goto leads Btn
    Then Recently Viewed lead Page will appear

    Examples: 
      | Update1        | Update2                                    | Update3                                                                                  |
      | Trying to call | Trying to Make coversation with client.... | client Accepted and going Explanaton of our services and Client Requesting our  Services |

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
