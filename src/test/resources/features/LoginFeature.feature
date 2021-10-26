Feature: Check login form

  Scenario: 01. Get warning message on Login page
    Given Login page is opened
    When Click on Continue button
    Then Appeared warning message "Please enter your email address" over email field


#  Scenario Outline: 011. Input email address
#    When Fill email field with email value <email>
#    And Click on button "Continue"
#    Then Appeared New customer form
#    Examples:
#      | email |
#      | test_1@gmail.com |
#      | test_2@gmail.com  |
#
#
#  Scenario: 012. Submit empty form
#    Given New customer form is loaded
#    When Scroll down the page
#    And Click on Continue button
#    Then Appeared warning message "Please enter your email address" over email field
