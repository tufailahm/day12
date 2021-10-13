Feature: Database Test

  Scenario: We should be able to connect to database and get the data
    When connection is established using
    And I run a select query to get the data
    Then I should see the result as oneplus900
