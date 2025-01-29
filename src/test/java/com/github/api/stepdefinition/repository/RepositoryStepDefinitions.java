package com.github.api.stepdefinition.repository;

import com.github.api.framework.model.ErrorResponse;
import com.github.api.framework.model.Repository;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class RepositoryStepDefinitions {
    private Repository createdRepository;
    private ErrorResponse errorResponse;
    private final SoftAssertions softAssertions;

    public RepositoryStepDefinitions() {
        softAssertions = new SoftAssertions();
    }

    @Steps
    RepositorySteps repositorySteps;

    @Given("user has a correct path {string}")
    public void preparePath(String path) {
        repositorySteps.setRepositoryPath(path);
    }

    @When("user creates repository with next valid data")
    public void createRepositoryWithValidData(Repository repository) {
        createdRepository = repositorySteps.createValidRepository(repository);
    }

    @When("user creates repository with next invalid data")
    public void createRepositoryWithInvalidData(Repository repository) {
        errorResponse = repositorySteps.createInvalidRepository(repository);
    }

    @When("user updates repository with valid data")
    public void updateRepositoryWithValidData(Repository repository) {
        setUriPathFromRepositoryObject(createdRepository);
        createdRepository = repositorySteps.updateRepositoryWithValidData(repository);
    }

    @When("user updates repository with invalid data")
    public void updateRepositoryWithInvalidData(Repository repository) {
        setUriPathFromRepositoryObject(createdRepository);
        errorResponse = repositorySteps.updateRepositoryWithInvalidData(repository);
    }

    @When("user deletes the repository")
    public void deleteExistingRepository() {
        setUriPathAndDeleteRepository(createdRepository);
    }

    @Then("repository is created")
    public void verifyCreateStatusCode() {
        verifyStatusCode(HttpStatus.SC_CREATED);
    }

    @Then("repository is updated")
    public void verifyUpdateStatusCode() {
        verifyStatusCode(HttpStatus.SC_OK);
    }

    @Then("repository is deleted")
    public void verifyDeleteStatusCode() {
        verifyStatusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Then("user deletes the un-existing repository {string}")
    public void deleteUnExistingRepository(String pathForDeletion) {
        errorResponse = repositorySteps.deleteNonExistingRepository(pathForDeletion);
    }

    @Then("{int} status code and {string} message are returned with next errors")
    public void verifyErrorResponseAndStatusCode(int expectedStatusCode, String commonMessage,
                                                 List<ErrorResponse.Error> errors) {
        verifyStatusCode(expectedStatusCode);
        softAssertions.assertThat(errorResponse.getMessage()).isEqualTo(commonMessage);

        if (!errors.isEmpty()) {
            softAssertions.assertThat(errorResponse.getErrors()).isEqualTo(errors);
        }
    }

    @And("read deleted repository")
    public void readAndVerifyThatRepositoryIsAbsent() {
        String pathForReading = getFormattedRepositoryPath(createdRepository.getFull_name());
        preparePath(pathForReading);
        errorResponse = repositorySteps.readNonExistingRepository(pathForReading);
    }

    @And("the repository contains all data")
    public void readAndVerifyThatRepositoryContainsAllData(Repository repository) {
        setUriPathFromRepositoryObject(repository);

        Repository repositoryFromResponse = repositorySteps.readExistingRepository();
        verifyStatusCode(HttpStatus.SC_OK);
        softAssertions.assertThat(repositoryFromResponse).isEqualTo(repository);
    }

    @After
    public void cleanup() {
        if (createdRepository != null) {
            setUriPathAndDeleteRepository(createdRepository);
        }
        softAssertions.assertAll();
    }

    private void setUriPathAndDeleteRepository(Repository repositoryObject) {
        String pathToDelete = getFormattedRepositoryPath(repositoryObject.getFull_name());
        repositorySteps.deleteRepository(pathToDelete);
    }

    private String getFormattedRepositoryPath(String repositoryFullName) {
        return String.format("/repos/%s", repositoryFullName);
    }

    private void setUriPathFromRepositoryObject(Repository repositoryObject) {
        String pathToGet = getFormattedRepositoryPath(repositoryObject.getFull_name());
        preparePath(pathToGet);
    }

    private void verifyStatusCode(int expectedStatusCode) {
        int actualStatusCode = repositorySteps.getStatusCodeFromResponse();
        softAssertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }
}