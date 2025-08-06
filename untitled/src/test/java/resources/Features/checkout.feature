Feature: Checkout functionality



  Scenario: Navigate to cart and checkout the added products
    Given user is on login page
    When user enters valid email address "standard_user"
    And user enters valid password "secret_sauce"
    And click on login button
    Then user should successfully logged in
    When user adds product "Sauce Labs Fleece Jacket" to the cart
    And user clicks on cart icon
    Then user should be on cart page
    And the product "Sauce Labs Fleece Jacket" should be listed in the cart
    Then click on checkout button
    And fill firstname "joe", lastname "jack" and postalcode "10001"
    Then click on continue button
    Then verify all the details as displayed
    And click on finish button
    And user can see the successful message


  Scenario: verify user is able to checkout without proper data
    Given user is on login page
    When user enters valid email address "standard_user"
    And user enters valid password "secret_sauce"
    And click on login button
    Then user should successfully logged in
    When user adds product "Sauce Labs Fleece Jacket" to the cart
    And user clicks on cart icon
    Then user should be on cart page
    And the product "Sauce Labs Fleece Jacket" should be listed in the cart
    Then click on checkout button
    And fill firstname "", lastname "" and postalcode ""
    Then click on continue button
    Then User should get error message "Error: First Name is required"


