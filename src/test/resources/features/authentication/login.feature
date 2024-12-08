@smoke
@Epic("EcomSite")
@Feature("UserManagement")
Feature: Login Test

  Background: User navigates to Application URL
    Given The application has been launched

  @Jira("S-456") # Link to Jira user story
  Scenario: User should be able to login with valid credentials
    When I enter "standard_user" in the Username text box
    And I enter "secret_sauce" in the Password text box
    And I click on the login button
    Then the system should display the "PRODUCTS" page

