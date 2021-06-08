# github-api-bdd-tests

**Project status**

[![pipeline status](https://gitlab.com/rekunjulia/github-api-bdd-tests/badges/main/pipeline.svg)](https://gitlab.com/rekunjulia/github-api-bdd-tests/-/commits/main)


**Documentation**

**How to install**
- checkout repository
- open console in the repository folder location 
- run `mvn -DskipTests test-compile`

**How to run tests**

There are to options:

_first option:_
- open **bash-based** console (e.g. git console)
- change directory to repository root folder
- run `sh test.sh {username} {token}`
- open test report located in - /target/site/serenity/index.html

_second option:_

Configure IDE and provide environment variables: $AUTH_BASIC_USERNAME$, $AUTH_BASIC_TOKEN$

_Potential improvements:_
In case we want to use cucumbers features and tags to controll scope of tests to be run, we should:
- mark appropriate tests scenarios with tags (e.g. @Smoke) in file.feature
- update test.sh file with `mvn clean verify -Dcucumber.options="--tags @Smoke"`
- run `sh test.sh {username} {token} {cucumber options}`

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
