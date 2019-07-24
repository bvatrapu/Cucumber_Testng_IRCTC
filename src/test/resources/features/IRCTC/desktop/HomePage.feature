@Regression @Desktop
Feature: Home Page

  Background: Open Browser and navigate to HomePage
    Given user navigates to HomePage

  @Regression @SmokeTest
  Scenario: Verify User login
    Then User Verifies Home Page is displayed
    When User clicks on Login
    Then Verify Login page is displayed
    When Enter Username and password to login
    Then Verify User Successfull login to Application