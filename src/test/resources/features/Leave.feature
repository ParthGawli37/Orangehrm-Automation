Feature: Leave

  Scenario: Apply Leave
    When user executes leave scenario "TS-LEAVE-001"
    Then leave scenario should pass

  Scenario: View Leave Records
    When user executes leave scenario "TS-LEAVE-002"
    Then leave scenario should pass

  Scenario: Cancel Leave
    When user executes leave scenario "TS-LEAVE-003"
    Then leave scenario should pass

  Scenario: Assign Leave
    When user executes leave scenario "TS-LEAVE-004"
    Then leave scenario should pass

  Scenario: Leave Validation
    When user executes leave scenario "TS-LEAVE-005"
    Then leave scenario should pass