@Regression @Desktop
Feature: Home Page

  Background: Open Browser and navigate to HomePage
    Given user navigates to HomePage

  @Regression @SmokeTest
  Scenario: Search for the products as a Guest User - All Direct Link
    Then User Verifies Home Page is displayed
    When User enter user name, Password and click on Signin
    Then User Verifies "mercuryreservation" Page is displayed