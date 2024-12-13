Feature: Order Checkout

  Background: User is logged in and on the product page
    Given User has logged in the page

  Scenario: Successfully place an order
    When I add "Sauce Labs Bike Light" to the cart
    And I proceed to checkout
    And I enter shipping details
      | firstname | lastname | zip   |
      | John      | Doe      | 12345 |
    And I continue to payment
    And I place the order
    Then I should see a confirmation message "Thank you for your order!"
