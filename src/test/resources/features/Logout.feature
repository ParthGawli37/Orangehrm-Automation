Feature: Logout

  Scenario: Standard Logout
    When user executes logout scenario "TS-LGOUT-001"
    Then logout scenario should pass

  Scenario: Session Termination
    When user executes logout scenario "TS-LGOUT-002"
    Then logout scenario should pass

  Scenario: Browser Back Button After Logout
    When user executes logout scenario "TS-LGOUT-003"
    Then logout scenario should pass

  Scenario: Direct URL Access After Logout
    When user executes logout scenario "TS-LGOUT-004"
    Then logout scenario should pass

  Scenario: Logout From User Menu
    When user executes logout scenario "TS-LGOUT-005"
    Then logout scenario should pass