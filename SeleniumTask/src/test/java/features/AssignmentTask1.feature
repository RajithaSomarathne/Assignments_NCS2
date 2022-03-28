Feature: Task1 to write automation code for rahulshettyacademy.com


  Scenario: Select the radio button

    Given User is on Rahul Shetty page
    When user select radio button
    Then verify the radio button has clicked


  Scenario: Select from suggestion class example

    Given User is on Rahul Shetty page
    When user select "Singapore" from dropdown
    Then verify the "Singapore" is set in the dropdown


  Scenario: Select from dropdown

    Given User is on Rahul Shetty page
    When user select "option3" from dropdownExample
    Then verify the "option3" got selected


  Scenario: Get text from the alert based on switch to Alert

    Given User is on Rahul Shetty page
    When user enter "Rajitha" in the textfield
    Then get the text from alert box
    And click ok button


  Scenario: Sum all price in web table

    Given User is on Rahul Shetty page
    When sum all price in Web Table
    Then verify sum of all rows is equal to the sum which has given








