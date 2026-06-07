Feature: Login

  Scenario: Valid Login
    When user executes login scenario "TS-LOGIN-001"
    Then scenario should pass

  Scenario: Invalid Credential Handling
    When user executes login scenario "TS-LOGIN-002"
    Then scenario should pass

  Scenario: Mandatory Field Validation
    When user executes login scenario "TS-LOGIN-003"
    Then scenario should pass

  Scenario: Password Masking
    When user executes login scenario "TS-LOGIN-004"
    Then scenario should pass

  Scenario: Forgot Password
    When user executes login scenario "TS-LOGIN-005"
    Then scenario should pass