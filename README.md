# GitHub API BDD Tests

This repository contains a simple and basic example of **Behavior-Driven Development (BDD)** framework for testing GitHub's RESTful API. It leverages **Cucumber** for BDD and **Rest-Assured** for API testing, enabling automated, readable, and maintainable tests.

## Table of Contents

- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Writing Tests](#writing-tests)
- [Running Tests](#running-tests)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

This project provides a framework for writing and executing BDD-style tests against GitHub's RESTful API. By leveraging **Cucumber's Gherkin syntax**, tests are both human-readable and executable, facilitating collaboration between developers and non-developers.

## Prerequisites

Ensure you have the following installed:

- **Java 8 or higher**
- **Gradle** (build automation tool)
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

## Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/thisisjulion/github-api-bdd-tests.git
   cd github-api-bdd-tests
   ```

2. Build the project:

   ```sh
   ./gradlew build
   ```

## Project Structure

```
github-api-bdd-tests/
├── src/
│   ├── main/java/com/yourcompany/api/
│   │   └── GitHubAPI.java
│   ├── main/java/com/yourcompany/utils/
│   │   └── RestClient.java
│   ├── test/java/com/yourcompany/steps/
│   │   └── GitHubSteps.java
│   ├── test/java/com/yourcompany/runners/
│   │   └── TestRunner.java
│   ├── test/resources/features/
│   │   └── github_api.feature
├── build.gradle
└── README.md
```

## Writing Tests

Feature files are written in **Gherkin syntax** within the `features/` directory. Each feature file corresponds to a specific API endpoint or functionality.

Example (`github_api.feature`):

```gherkin
Feature: GitHub API Authentication

  Scenario: Successful authentication with valid credentials
    Given I have valid GitHub credentials
    When I authenticate with the GitHub API
    Then I should receive a successful response
```

Each step is mapped to a method in the corresponding step definition class within `steps/`.

## Running Tests

Run tests using:

```sh
./gradlew test
```

Reports are generated in `build/reports/tests/test/`.


For more on BDD and Cucumber, visit [Cucumber Documentation](https://cucumber.io/docs/guides/10-minute-tutorial/).
