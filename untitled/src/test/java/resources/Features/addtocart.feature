Feature: Add products to the shopping cart



  Scenario: Navigate to cart and verify added products
    Given user is on login page
    When user enters valid email address "standard_user"
    And user enters valid password "secret_sauce"
    And click on login button
    Then user should successfully logged in
    When user adds product "Sauce Labs Bolt T-Shirt" to the cart
    And user clicks on cart icon
    Then user should be on cart page
    And the product "Sauce Labs Bolt T-Shirt" should be listed in the cart



  Scenario: Add a single product to the cart
    Given user is on login page
    When user enters valid email address "standard_user"
    And user enters valid password "secret_sauce"
    And click on login button
    Then user should successfully logged in
    When user adds "Sauce Labs Backpack" item to the cart
    Then cart should display "1" item
    And "Sauce Labs Backpack" should be visible in the cart





  Scenario: Add multiple products to the cart
    Given user is on login page
    When user enters valid email address "standard_user"
    And user enters valid password "secret_sauce"
    And click on login button
    Then user should successfully logged in
    When user adds product "Sauce Labs Bike Light" to the cart
    And user goes back to products page
    And user adds product "Sauce Labs Backpack" to the cart
    Then the cart icon should show "2"
    And both products "Sauce Labs Bike Light" and "Sauce Labs Backpack" should be visible in the cart


  Scenario: Remove a product from the cart
    Given user is on login page
    When user enters valid email address "standard_user"
    And user enters valid password "secret_sauce"
    And click on login button
    Then user should successfully logged in
    When user adds product "Sauce Labs Onesie" to the cart
    And user removes product "Sauce Labs Onesie" from the cart
    Then the cart icon should show "0"
    And the cart should be empty