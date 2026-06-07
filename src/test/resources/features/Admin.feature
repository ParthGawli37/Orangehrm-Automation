Feature: Admin

  Scenario: Add New User
    When user executes admin scenario "TS-ADMIN-001"
    Then admin scenario should pass

  Scenario: Edit Existing User
    When user executes admin scenario "TS-ADMIN-002"
    Then admin scenario should pass

  Scenario: Delete User
    When user executes admin scenario "TS-ADMIN-003"
    Then admin scenario should pass

  Scenario: Search User
    When user executes admin scenario "TS-ADMIN-004"
    Then admin scenario should pass

  Scenario: User Role Validation
    When user executes admin scenario "TS-ADMIN-005"
    Then admin scenario should pass