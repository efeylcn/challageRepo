Feature: Editing and Deleting Employee

  @TST-106 @smokeTest @regressionTest @ui
  Scenario Outline: Edit Employee
    Given an Employer
    And I am on the Benefits Dashboard page
    When I select the Action Edit
    Then I can edit employee details "<lastName>" "<name>" "<numOfDependent>"
    And the data should change in the table "<lastName>" "<name>" "<numOfDependent>"
    Examples:
      | lastName  | name    | numOfDependent |
      | Webrovsky | Vitalii | 2              |


  @TST-107 @smokeTest @regressionTest @ui
  Scenario Outline: Delete Employee
    Given an Employer
    And I am on the Benefits Dashboard page
    When I click the Action X
    Then the employee should be deleted "<lastName>" "<name>" "<numOfDependent>"
    Examples:
      | lastName  | name    | numOfDependent |
      | Webrovsky | Vitalii | 2              |
