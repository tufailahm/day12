Feature: feature to test login functionality

  Scenario Outline: Check whether login is successful with valid credentials or not
    Given browser is opened
    And user is on login page
    When user enters <username> and <password>
    And user clicks on login button
    Then user is navigated to the home page

    Examples: |
      | username | password |
      | Tufail   |    12345 |
      | William  |    123451 |
      | Steven   |    123452 |
