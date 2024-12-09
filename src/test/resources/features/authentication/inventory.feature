@smoke
@Epic("EcomSite")
@Feature("UserManagement")
Feature: Product Search

  Background: User navigates to Products page
    Given User has logged in the page

  @Jira("S-556") # Link to Jira user story
  Scenario: Successfully search for a product by name
    When I am on Product page
    And Search for an item with title "Sauce Labs Backpack"
    Then User should able to find the product