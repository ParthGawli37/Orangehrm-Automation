Feature: Dashboard

  Scenario: Dashboard Load And Widget Visibility
    When user executes dashboard scenario "TS-DASH-001"
    Then dashboard scenario should pass

  Scenario: Navigation Between Modules
    When user executes dashboard scenario "TS-DASH-002"
    Then dashboard scenario should pass

  Scenario: Role Based Content
    When user executes dashboard scenario "TS-DASH-003"
    Then dashboard scenario should pass

  Scenario: Refresh Behavior
    When user executes dashboard scenario "TS-DASH-004"
    Then dashboard scenario should pass

  Scenario: Profile Menu And User Options
    When user executes dashboard scenario "TS-DASH-005"
    Then dashboard scenario should pass