@regression
@Epic("EcomSite")
@Feature("ProductManagement")
Feature: Add/Remove Item to/from Cart

  Background: User is logged in and on the product page
    Given User has logged in the page

  Scenario Outline: Successfully add an item to the cart
    When I add "<productName>" to the cart
    Then I see "<productName>" in the cart

    Examples:
      | productName              |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |

  Scenario: Successfully add and remove an item from the cart
    When I add "Sauce Labs Fleece Jacket" to the cart
    Then I see "Sauce Labs Fleece Jacket" in the cart
    When I remove "Sauce Labs Fleece Jacket" from the cart
    Then I should not see "Sauce Labs Fleece Jacket" in the cart


