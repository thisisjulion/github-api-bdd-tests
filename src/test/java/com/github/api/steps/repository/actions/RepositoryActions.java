package com.github.api.steps.repository.actions;

import com.github.api.steps.common.actions.BaseActions;
import com.github.api.steps.common.model.ErrorResponse;
import com.github.api.steps.repository.model.Repository;
import io.restassured.response.ValidatableResponse;

public class RepositoryActions extends BaseActions {
    private String repositoryPath;
    private ValidatableResponse validatableResponse;

    public void setRepositoryPath(String path) {
        this.repositoryPath = path;
    }

    /**
     * Create valid repository and get created object
     *
     * @param repository object to create
     * @return the created Repository
     */
    public Repository createValidRepository(Repository repository) {
        validatableResponse = create(repositoryPath, repository);
        return getObjectFromResponse(validatableResponse, Repository.class);
    }

    /**
     * Create invalid repository and get error response
     *
     * @param repository object to create
     * @return the error response
     */
    public ErrorResponse createInvalidRepository(Repository repository) {
        validatableResponse = create(repositoryPath, repository);
        return getObjectFromResponse(validatableResponse, ErrorResponse.class);
    }

    /**
     * Update repository using valid data and get updated object
     *
     * @param repository object to update
     * @return the updated Repository
     */
    public Repository updateRepositoryWithValidData(Repository repository) {
        validatableResponse = patch(repositoryPath, repository);
        return getObjectFromResponse(validatableResponse, Repository.class);
    }

    /**
     * Update repository using invalid data and get error response
     *
     * @param repository object to update
     * @return the error response
     */
    public ErrorResponse updateRepositoryWithInvalidData(Repository repository) {
        validatableResponse = patch(repositoryPath, repository);
        return getObjectFromResponse(validatableResponse, ErrorResponse.class);
    }

    /**
     * Read repository and get object
     *
     * @return the Repository
     */
    public Repository readExistingRepository() {
        validatableResponse = read(repositoryPath);
        return getObjectFromResponse(validatableResponse, Repository.class);
    }

    /**
     * Read non-existing repository and get error response
     *
     * @param repositoryPath the path
     * @return the ErrorResponse
     */
    public ErrorResponse readNonExistingRepository(String repositoryPath) {
        validatableResponse = read(repositoryPath);
        return getObjectFromResponse(validatableResponse, ErrorResponse.class);
    }

    /**
     * Delete repository
     *
     * @param repositoryPath the path
     */
    public void deleteRepository(String repositoryPath) {
        validatableResponse = delete(repositoryPath);
    }

    /**
     * Delete non-existing repository and get error response
     *
     * @param repositoryPath the path
     * @return the ErrorResponse
     */
    public ErrorResponse deleteNonExistingRepository(String repositoryPath) {
        validatableResponse = delete(repositoryPath);
        return getObjectFromResponse(validatableResponse, ErrorResponse.class);
    }

    public void verifyStatusCode(int expectedStatusCode) {
        verifyStatusCode(validatableResponse, expectedStatusCode);
    }
}