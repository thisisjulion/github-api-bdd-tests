Feature: As a User I want to be able to create repository

  @Test-1
  Scenario: User should be able to create new personal repository filling only required field
    Given user has a correct path "/user/repos"
    When user creates repository with next valid data
      | name             |
      | repoOnlyRequired |
    Then repository is created
    And the repository contains all data
      | has_downloads | has_issues | has_wiki | name             | fullName                      | isPrivate |
      | true          | true       | true     | repoOnlyRequired | {your_github_name}/repoOnlyRequired | false     |

  Scenario: User should be able to create new personal repository filling all fields
    Given user has a correct path "/user/repos"
    When user creates repository with next valid data
      | auto_init | description | gitignore_template | has_downloads | has_issues | has_wiki | homepage       | name     | isPrivate |
      | false     | test        | Haskell            | false         | false      | false    | test home page | repoFull | true      |
    Then repository is created
    And the repository contains all data
      | description | has_downloads | has_issues | has_wiki | homepage       | name     | fullName              | isPrivate |
      | test        | false         | false      | false    | test home page | repoFull | {your_github_name}/repoFull | true      |

  Scenario: User should not be able to create new repository missing required field
    Given user has a correct path "/user/repos"
    When user creates repository with next invalid data
      | auto_init | description | has_downloads | has_issues | has_wiki | homepage       | isPrivate |
      | false     | test        | false         | false      | false    | test home page | true      |
    Then 422 status code and "Repository creation failed." message are returned with next errors
      | field | code          |
      | name  | missing_field |
      | name  | custom        |

  Scenario: User should not be able to create new repository with too short name field
    Given user has a correct path "/user/repos"
    When user creates repository with next invalid data
      | name    |
      | [blank] |
    Then 422 status code and "Repository creation failed." message are returned with next errors
      | field | code          |
      | name  | missing_field |
      | name  | custom        |

  Scenario: User should not be able to create new repository with un-unique name
    Given user has a correct path "/user/repos"
    And user creates repository with next valid data
      | name                 |
      | repoFromPrecondition |
    When user creates repository with next invalid data
      | name                 |
      | repoFromPrecondition |
    Then 422 status code and "Repository creation failed." message are returned with next errors
      | field | code   |
      | name  | custom |

  Scenario: User should not be able to create new repository with unknown gitignore template
    Given user has a correct path "/user/repos"
    When user creates repository with next invalid data
      | name             | gitignore_template |
      | invalid template | invalid            |
    Then 422 status code and "Repository creation failed." message are returned with next errors
      | field              | code   |
      | gitignore_template | custom |
