Feature: Desktop Web UI - Redmine - Projects
  As a user ...
  I want to ...

  @e2e
  Scenario: Create a Project
    Given I go to the Redmine login page on URL
    And I login with my credentials user "user" and "bitnami1"
    When I create a project
      | name        | RedmineProject                                     |
      | description | Esta es una descripción de una prueba automatizada |
      | homepage    | RedmineProject                                     |
      | public      | true                                               |
    Then The project was successfully created
