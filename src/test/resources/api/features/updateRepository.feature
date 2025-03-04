Feature: As a User I want to be able to update repository

  Scenario: User should be able to update created repository providing only required fields
    Given user has a correct path "/user/repos"
    And user creates repository with next valid data
      | auto_init | description | gitignore_template | has_downloads | has_issues | has_wiki | homepage       | name | isPrivate |
      | true      | test        | Haskell            | true          | true       | true     | test home page | repo | true      |
    When user updates repository with valid data
      | name    |
      | repoUPD |
    Then repository is updated
    And the repository contains all data
      | description | has_downloads | has_issues | has_wiki | homepage       | name    | fullName             | isPrivate |
      | test        | true          | true       | true     | test home page | repoUPD | {your_github_name}/repoUPD | true      |

  Scenario: User should be able to update created repository changing all possible fields
    Given user has a correct path "/user/repos"
    And user creates repository with next valid data
      | auto_init | description | gitignore_template | has_downloads | has_issues | has_wiki | homepage       | name | isPrivate |
      | false     | test        | Haskell            | false         | false      | false    | test home page | repo | false     |
    When user updates repository with valid data
      | description | has_downloads | has_issues | has_wiki | homepage           | name    | isPrivate |
      | testUPD     | true          | true       | true     | test home page UPD | repoUPD | true      |
    Then repository is updated
    And the repository contains all data
      | description | has_downloads | has_issues | has_wiki | homepage           | name    | fullName             | isPrivate |
      | testUPD     | true          | true       | true     | test home page UPD | repoUPD | {your_github_name}/repoUPD | true      |

  Scenario: User should not able to update created repository providing too short name field
    Given user has a correct path "/user/repos"
    And user creates repository with next valid data
      | name |
      | repo |
    When user updates repository with invalid data
      | name    |
      | [blank] |
    Then 422 status code and "Validation Failed" message are returned with next errors
      | field | code   |
      | name  | custom |

  Scenario: Repository shouldn't be changed if User provides empty body for update
    Given user has a correct path "/user/repos"
    And user creates repository with next valid data
      | auto_init | description | gitignore_template | has_downloads | has_issues | has_wiki | homepage       | name | isPrivate |
      | false     | test        | Haskell            | false         | false      | false    | test home page | repo | false     |
    When user updates repository with invalid data
      | description | has_downloads | has_issues | has_wiki | homepage | name | isPrivate |
      |             |               |            |          |          |      |           |
    Then repository is updated
    And the repository contains all data
      | description | has_downloads | has_issues | has_wiki | homepage       | name | fullName          | isPrivate |
      | test        | false         | false      | false    | test home page | repo | {your_github_name}/repo | false     |
