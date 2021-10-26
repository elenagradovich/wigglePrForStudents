Feature: Sequential following through the links on the site

  Scenario: 01. Open Main page and follow to Login page
    Given Main page is loaded
    When Find active navigation link
    Then Check if the active navigation tab is "Outlet"
    When Click on login link
    Then Login page is loaded


  Scenario: 02. Get warning message on Login page
    Given Login page is opened
    When Click on Continue button
    Then Appeared warning message "Please enter your email address" over email field


  Scenario Outline: 021. Input email address
    When Fill email field with value "<email>"
    And Press on Continue button
    Then Appeared New customer form
    Examples:s
      | email |
      | example@gmail.com |


  Scenario: 03. Submit empty form
    Given New customer form is loaded
    When Scroll down NewCustomer page
    And Click on Continue Login button
    Then Warning message "Please ensure you have entered a password with at least 6 characters containing both letters and numbers" is showed over email field

