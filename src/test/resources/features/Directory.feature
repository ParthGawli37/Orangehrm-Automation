Feature: Directory

  Scenario: Search Employee
    When user executes directory scenario "TS-DIR-001"
    Then directory scenario should pass

  Scenario: Employee Information
    When user executes directory scenario "TS-DIR-002"
    Then directory scenario should pass

  Scenario: Job Title Search
    When user executes directory scenario "TS-DIR-003"
    Then directory scenario should pass

  Scenario: Location Search
    When user executes directory scenario "TS-DIR-004"
    Then directory scenario should pass

  Scenario: Directory Validation
    When user executes directory scenario "TS-DIR-005"
    Then directory scenario should pass