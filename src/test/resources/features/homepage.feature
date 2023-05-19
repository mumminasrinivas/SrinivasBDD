Feature: Home Page UI validations for the https://reqres.in/ website

  As a user I can able to Navigate to reqres website home page
  and see the list of different request types and respective end points
  So that I can able to verify each request and respective end point

  Background:
    Given I am on the reqres website home page

  Scenario: Verify Request and Response codes in reqres website
    Given I have Navigated to Request and Response codes table
    When I click on Key options available in left side
    Then respective sample request and response details should be displayed

  Scenario: Verify user able to navigate to support page
    Given I have seen support button on page
    When I click on support button
    Then Support page should be displayed

  Scenario: Verify support page options
    Given I am on support page
    When I check the options on support page
    Then I should be able to see the options for one-time and monthly support and upgrade button below the support page

