package com.github.api.steps.repository.definitions;

import com.github.api.steps.common.model.ErrorResponse;
import com.github.api.steps.repository.model.Repository;
import com.github.api.steps.common.actions.BaseActions;
import com.github.api.steps.repository.actions.RepositoryActions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.http.HttpStatus;

import java.util.List;

public class RepositoryStepDefinitions {
    private Repository createdRepository;
    private ErrorResponse errorResponse;

    @Steps
    RepositoryActions repositoryActions;

    @Given("user has a correct path {string}")
    public void preparePath(String path) {
        repositoryActions.setRepositoryPath(path);
    }

    @When("user creates repository with next valid data")
    public void createRepositoryWithValidData(Repository repository) {
        createdRepository = repositoryActions.createValidRepository(repository);
    }

    @When("user creates repository with next invalid data")
    public void createRepositoryWithInvalidData(Repository repository) {
        errorResponse = repositoryActions.createInvalidRepository(repository);
    }

    @When("user updates repository with valid data")
    public void updateRepositoryWithValidData(Repository repository) {
        setUriPathFromRepositoryObject(createdRepository);
        createdRepository = repositoryActions.updateRepositoryWithValidData(repository);
    }

    @When("user updates repository with invalid data")
    public void updateRepositoryWithInvalidData(Repository repository) {
        setUriPathFromRepositoryObject(createdRepository);
        errorResponse = repositoryActions.updateRepositoryWithInvalidData(repository);
    }

    @When("user deletes the repository")
    public void deleteExistingRepository() {
        setUriPathAndDeleteRepository(createdRepository);
    }

    @Then("repository is created")
    public void verifyCreateStatusCode() {
        repositoryActions.verifyStatusCode(HttpStatus.SC_CREATED);
    }

    @Then("repository is updated")
    public void verifyUpdateStatusCode() {
        repositoryActions.verifyStatusCode(HttpStatus.SC_OK);
    }

    @Then("repository is deleted")
    public void verifyDeleteStatusCode() {
        repositoryActions.verifyStatusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Then("user deletes the un-existing repository {string}")
    public void deleteUnExistingRepository(String pathForDeletion) {
        errorResponse = repositoryActions.deleteNonExistingRepository(pathForDeletion);
    }

    @Then("{int} status code and {string} message are returned with next errors")
    public void verifyErrorResponseAndStatusCode(int expectedStatusCode, String commonMessage,
                                                 List<ErrorResponse.Error> errors) {
        repositoryActions.verifyStatusCode(expectedStatusCode);
        repositoryActions.verifyObject(commonMessage, errorResponse.getMessage());

        if (!errors.isEmpty()) {
            repositoryActions.verifyListOfObjects(errors, errorResponse.getErrors());
        }
    }

    @And("read deleted repository")
    public void readAndVerifyThatRepositoryIsAbsent() {
        String pathForReading = getFormattedRepositoryPath(createdRepository.getFull_name());
        preparePath(pathForReading);
        errorResponse = repositoryActions.readNonExistingRepository(pathForReading);
    }

    @And("the repository contains all data")
    public void readAndVerifyThatRepositoryContainsAllData(Repository repository) {
        setUriPathFromRepositoryObject(repository);

        Repository repositoryFromResponse = repositoryActions.readExistingRepository();
        repositoryActions.verifyStatusCode(HttpStatus.SC_OK);
        repositoryActions.verifyObject(repository, repositoryFromResponse);
    }

    @After
    public void deleteCreatedDataIfNeeded() {
        if (createdRepository != null) {
            setUriPathAndDeleteRepository(createdRepository);
        }
        BaseActions.softAssertions.assertAll();
    }

    private void setUriPathAndDeleteRepository(Repository repositoryObject) {
        String pathToDelete = getFormattedRepositoryPath(repositoryObject.getFull_name());
        repositoryActions.deleteRepository(pathToDelete);
    }

    private String getFormattedRepositoryPath(String repositoryFullName) {
        return String.format("/repos/%s", repositoryFullName);
    }

    private void setUriPathFromRepositoryObject(Repository repositoryObject) {
        String pathToGet = getFormattedRepositoryPath(repositoryObject.getFull_name());
        preparePath(pathToGet);
    }
}
