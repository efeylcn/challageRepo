Feature: Adding Employee on the Dash Board


  @TST-104 @smokeTest @regressionTest @ui
  Scenario Outline: Add Employee no Discount
    Given an Employer
    And I am on the Benefits Dashboard page
    When I select Add Employee
    Then I should be able to enter employee details "<lastName>" "<name>" "<numOfDependent>"
    And First Name does not begin with “A” or “a” "<name>"
    And the employee should save
    And I should see the employee in the table "<lastName>" "<name>" "<numOfDependent>"
    And the benefit cost calculations are correct "<lastName>" "<name>" "<numOfDependent>"
    Examples:
      | lastName | name | numOfDependent |
      | Smith    | John | 2              |


  @TST-105 @smokeTest @regressionTest @ui
  Scenario Outline: Add Employee with Discount
    Given an Employer
    And I am on the Benefits Dashboard page
    When I select Add Employee
    Then I should be able to enter employee details "<lastName>" "<name>" "<numOfDependent>"
    And First Name begins with “A” or “a” "<name>"
    And the employee should save
    And I should see the employee in the table "<lastName>" "<name>" "<numOfDependent>"
    And the employee has a 10% discount "<numOfDependent>"
    Examples:
      | lastName | name | numOfDependent |
      | Souza    | Alex | 1              |


