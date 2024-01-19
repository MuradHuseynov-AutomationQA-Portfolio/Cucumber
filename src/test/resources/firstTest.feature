Feature: Portfolio

  Background: Authorization
    Given Open 3commas page
    Given Sign in

  Scenario: Create new portfolio
    And Open My Portfolios page
    And Close iframe and popup
    And Click to Create New Portfolio button
    And Enter name
    And Choose exhange type
    And Choose coin
    And Click Save + Publish button
    And Open My Portfolios page
    Then Check new portfolio created