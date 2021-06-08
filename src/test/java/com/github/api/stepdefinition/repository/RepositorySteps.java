package com.github.api.stepdefinition.repository;

import com.github.api.framework.model.ErrorResponse;
import com.github.api.framework.model.Repository;
import com.github.api.framework.service.ApiClient;
import io.restassured.response.ValidatableResponse;

import java.util.Optional;

public class RepositorySteps {
    private String repositoryPath;
    private ValidatableResponse validatableResponse;
    private ApiClient apiClient;

    public RepositorySteps() {
        apiClient = new ApiClient();
    }

    /**
     * Set repository path
     *
     * @param path the path
     */
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
        validatableResponse = apiClient.create(repositoryPath, repository);
        return apiClient.getObjectFromResponse(validatableResponse, Repository.class);
    }

    /**
     * Create invalid repository and get error response
     *
     * @param repository object to create
     * @return the error response
     */
    public ErrorResponse createInvalidRepository(Repository repository) {
        validatableResponse = apiClient.create(repositoryPath, repository);
        return apiClient.getObjectFromResponse(validatableResponse, ErrorResponse.class);
    }

    /**
     * Update repository using valid data and get updated object
     *
     * @param repository object to update
     * @return the updated Repository
     */
    public Repository updateRepositoryWithValidData(Repository repository) {
        validatableResponse = apiClient.patch(repositoryPath, repository);
        return apiClient.getObjectFromResponse(validatableResponse, Repository.class);
    }

    /**
     * Update repository using invalid data and get error response
     *
     * @param repository object to update
     * @return the error response
     */
    public ErrorResponse updateRepositoryWithInvalidData(Repository repository) {
        validatableResponse = apiClient.patch(repositoryPath, repository);
        return apiClient.getObjectFromResponse(validatableResponse, ErrorResponse.class);
    }

    /**
     * Read repository and get object
     *
     * @return the Repository
     */
    public Repository readExistingRepository() {
        validatableResponse = apiClient.read(repositoryPath);
        return apiClient.getObjectFromResponse(validatableResponse, Repository.class);
    }

    /**
     * Read non-existing repository and get error response
     *
     * @param repositoryPath the path
     * @return the ErrorResponse
     */
    public ErrorResponse readNonExistingRepository(String repositoryPath) {
        validatableResponse = apiClient.read(repositoryPath);
        return apiClient.getObjectFromResponse(validatableResponse, ErrorResponse.class);
    }

    /**
     * Delete repository
     *
     * @param repositoryPath the path
     */
    public void deleteRepository(String repositoryPath) {
        validatableResponse = apiClient.delete(repositoryPath);
    }

    /**
     * Delete non-existing repository and get error response
     *
     * @param repositoryPath the path
     * @return the ErrorResponse
     */
    public ErrorResponse deleteNonExistingRepository(String repositoryPath) {
        validatableResponse = apiClient.delete(repositoryPath);
        return apiClient.getObjectFromResponse(validatableResponse, ErrorResponse.class);
    }

    /**
     * Get status code from response
     *
     * @return status code as int
     */
    public int getStatusCodeFromResponse() {
        return Optional.ofNullable(validatableResponse)
                .map(it -> it.extract().statusCode())
                .orElse(-1);
    }
}