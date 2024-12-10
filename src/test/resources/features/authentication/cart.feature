@smoke
@Epic("EcomSite")
@Feature("ProductManagement")
Feature: Add Item to Cart

  Background: User is logged in and on the product page
    Given User has logged in the page

  Scenario Outline: Successfully add an item to the cart
    When I add "<productName>" to the cart
    Then I   see "<productName>" in the cart

    Examples:
      | productName              |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |