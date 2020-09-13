Feature: Desktop Web UI - Redmine - Users
  As a user ...
  I want to ...

  @e2e
  Scenario: Create a User
    Given I go to the Redmine login page on URL
    And I login with my credentials user "user" and "bitnami1"
    When I create a user
      | userName      | user              |
      | firstName     | userFirstName     |
      | lastName      | userLastName      |
      | email         | @mail.com         |
      | language      | Spanish (Español) |
      | administrator | true              |
      | password      | 12345678          |
    Then The user was successfully created
    And The User should be available in User list