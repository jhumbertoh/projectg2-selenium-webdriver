Feature: Desktop WEB UI Redmine Login
  As a user,
  I Want to be able to login on Redmine

  @e2e
  Scenario: User inputs correct username and password
    Given I go to the Redmine login page on URL
    When I login with my credentials user "user" and "bitnami1"
    Then I should see the homepage with the username "user"
