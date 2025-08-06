Feature: Login Functionality



  Scenario: Login with valid credentials
    Given user is on login page
    When user enters valid email address "standard_user"
    And user enters valid password "secret_sauce"
    And click on login button
    Then user should successfully logged in


  Scenario: Login with invalid credentials
    Given user is on login page
    When user enters invalid email address "admin_user"
    And user enters invalid password "secret"
    And click on login button
    Then user should get error message



  Scenario: Login with invalid password
    Given user is on login page
    When user enters valid email address "standard_user"
    And user enters invalid password "sauce"
    And click on login button
    Then user should get error message



  Scenario: Login with invalid email address
    Given user is on login page
    When user enters invalid email address "secret_sauce"
    And user enters valid password "secret_sauce"
    And click on login button
    Then user should get error message



  Scenario: Login with without any credentials
    Given user is on login page
    When user does not enter any email address ""
    And user does not enter any password ""
    And click on login button
    Then user should get error message

    Scenario: logout from the application
      Given user is on login page
      When user enters valid email address "standard_user"
      And user enters valid password "secret_sauce"
      And click on login button
      Then user should successfully logged in
      And click on logout button



