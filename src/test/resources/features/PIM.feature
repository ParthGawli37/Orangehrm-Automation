Feature: PIM

  Scenario: Add Employee
    When user executes pim scenario "TS-PIM-001"
    Then pim scenario should pass

  Scenario: Search Employee
    When user executes pim scenario "TS-PIM-002"
    Then pim scenario should pass

  Scenario: Update Employee
    When user executes pim scenario "TS-PIM-003"
    Then pim scenario should pass

  Scenario: Delete Employee
    When user executes pim scenario "TS-PIM-004"
    Then pim scenario should pass

  Scenario: Employee Validation
    When user executes pim scenario "TS-PIM-005"
    Then pim scenario should pass