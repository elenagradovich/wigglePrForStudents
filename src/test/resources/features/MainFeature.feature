Feature: Sequential following through the links on the site

  Scenario: 01. Open Main page and follow to Login page
    Given Main page is loaded
    When Find active navigation link
    Then Check if the active navigation tab is "Outlet"
    When Click on login link
    Then Login page is loaded

#  Scenario: 03. Get warning message on Login page
#    Given Login page is loaded
#    When Click on button "Continue" with id "qa-dual-register"
#    Then Appeared warning message "Please enter your email address" in element id "DualRegisterEmailModel_Email-error"
#
#
#  Scenario Outline: 031. Input email address
#    When Fill email field with email value <address>
#    And Click on button "Continue" with id "qa-dual-register"
#    Then Appeared New customer form
#    Examples:
#      | address |
#      | test_1@gmail.com s|
#      | test_2@gmail.com  |
#
#
#  Scenario: 032. Submit empty form
#    Given New customer form is loaded
#    When Scroll down the page
#    And Click on element having id "qa-register"
#    Then Appeared warning message "Please enter your email address" in element id "RegisterModel_EmailConfirm-error"
