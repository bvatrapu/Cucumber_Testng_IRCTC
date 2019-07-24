@Regression @Desktop
Feature: Home Page

  Background: Open Browser and navigate to HomePage
    Given user navigates to HomePage

  @Regression @SmokeTest
  Scenario: Search for the products as a Guest User - All Direct Link
    Then User Verifies "/pharmacy" Page is displayed
