Feature: Sequential following through the links on the site

  Scenario: 01. Open Main page and follow to Login page
    Given Main page is loaded
    When Find active navigation link
    Then Check if the active navigation tab is "Outlet"
    When Click on login link
    Then Login page is loaded
