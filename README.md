# github-api-bdd-tests

**Documentation**

This repository is an example of how to write BDD tests using Cucumber and RestAssured for scenario definitions and Serenity BDD for generating detailed reports. 
The tests are based on public api of github - https://api.github.com

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
