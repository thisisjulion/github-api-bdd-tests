Feature: As a User I want to be able to delete repository

  Scenario: User should be able to delete created repository
    Given user has a correct path "/user/repos"
    And user creates repository with next valid data
      | name         |
      | repoToDelete |
    When user deletes the repository
    Then repository is deleted
    And read deleted repository
    And 404 status code and "Not Found" message are returned with next errors
      |  |  |

  Scenario: User should not able to delete un-existing repository
    When user deletes the un-existing repository "/{your_github_name}/none"
    Then 404 status code and "Not Found" message are returned with next errors
      |  |  |