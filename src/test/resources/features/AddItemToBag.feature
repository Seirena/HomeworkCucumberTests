Feature: Test filling an Svoe_Rodnoe cart

  Scenario: Validate total amount of items increases to 3
    Given user is on Svoe_Rodnoe main page
    And user choose his city is 'Москва'
    When user search 'Блины с мясом'
    And click on item button of first result
    And click on add item button
    And click twice on plus-button to add two more items
    Then total amount of items in cart shows '3'

  Scenario: authorization with wrong phone number and code shows error message
    Given user is on Svoe_Rodnoe main page
    When click on account-button
    And enter wrong phone number '9710771111'
    And enter wrong code '123141'
    Then error message is visible

    And end test