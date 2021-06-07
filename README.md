# github-api-bdd-tests

**Project status**

[![pipeline status](https://gitlab.com/rekunjulia/github-api-bdd-tests/badges/main/pipeline.svg)](https://gitlab.com/rekunjulia/github-api-bdd-tests/-/commits/main)


**Documentation**

**How to install**
- checkout repository
- open console in the repository folder location 
- run `mvn install`

**How to run tests**

- open com.github.api.TestRunner and configure parameters in @CucumberOptions

_features_ - to run tests by feature folders

_tags_ - to run tests by tags (tags should be added to each Scenario)

Then there are to options:

_first option:_
- open **bash-based** console (e.g. git console)
- change directory to repository root folder
- run `sh test.sh {username} {token}`
- open test report located in - /target/site/serenity/index.html

_second option:_

Configure IDE and provide environment variables: $AUTH_BASIC_USERNAME$, $AUTH_BASIC_TOKEN$

**How to write new tests**
- create new file.feature new others .feature files

- write new test in next format
 <details><summary>click here to view</summary>
Feature: As a User I want to be able to create repository

Scenario: User should be able to create new personal repository filling only required field

Given user has a correct path "/user/repos"
When user creates repository with next valid data
Then repository is created
</details>

- implement step definitions in SomeStepDefinition class in next format

```
@Given("user has a correct path {string}")
public void preparePath(String path) {
//some implementation
}
```
