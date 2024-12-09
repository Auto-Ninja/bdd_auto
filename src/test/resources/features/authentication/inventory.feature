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

  Scenario: Successfully search for products by name
    When I am on Product page
    And I search for the following products
      | productName              |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |
    Then User should able to find the list of product
