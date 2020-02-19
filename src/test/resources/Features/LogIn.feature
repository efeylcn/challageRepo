Feature: Verifying login functionality

  Background:
    Given Navigate to login page
    When User logs in with valid credentials username "testUser" password "Test1234"
    Then Verify user is on the Dashboard

  @TST-101  @smokeTest @regressionTest @ui
  Scenario: Verifying with valid credentials
    Given Navigate to login page
    When User logs in with valid credentials username "testUser" password "Test1234"
    Then Verify user is on the Dashboard

  @TST-102 @ui
  Scenario: Verifying with invalid credentials
    Given Navigate to login page
    When User logs in with Valid username "testUser" INVALID password "***"
    Then Verify user gets error message

  @TST-103 @ui
  Scenario: Verifying with invalid credentials
    Given Navigate to login page
    When User logs in with INVALID username "xyz" VALID password "Test1234"
    Then Verify user gets invalid password message

