package com.github.api.framework.service;

import io.restassured.response.ValidatableResponse;

import static com.github.api.framework.extension.RestAssuredExtension.givenUserBasicAuthorization;

public class ApiClient {

    /**
     * POST request with possibility to provide path and object to be created
     * Object will be serialized to JSON
     *
     * @param path           path
     * @param objectToCreate object to create
     * @return ValidatableResponse the response
     */
    public ValidatableResponse create(String path, Object objectToCreate) {
        return givenUserBasicAuthorization().body(objectToCreate)
                .when().post(path)
                .then();
    }

    /**
     * GET request
     *
     * @param path path
     * @return ValidatableResponse the response
     */
    public ValidatableResponse read(String path) {
        return givenUserBasicAuthorization()
                .when().get(path)
                .then();
    }

    /**
     * PATCH request with possibility to provide path and object to be update
     * Object will be serialized to JSON
     *
     * @param path path
     * @param objectToUpdate object to update
     * @return ValidatableResponse the response
     */
    public ValidatableResponse patch(String path, Object objectToUpdate) {
        return givenUserBasicAuthorization().body(objectToUpdate)
                .when().patch(path)
                .then();
    }

    /**
     * DELETE request
     *
     * @param path path
     * @return ValidatableResponse the response
     */
    public ValidatableResponse delete(String path) {
        return givenUserBasicAuthorization()
                .when().delete(path)
                .then();
    }

    /**
     * Get object from response
     *
     * @param validatableResponse the validatable response
     * @param clazz class of object
     * @param <T> the generic
     * @return the object
     */
    public  <T> T getObjectFromResponse(ValidatableResponse validatableResponse,
                                          Class<T> clazz) {
        return validatableResponse.extract().body().as(clazz);
    }
}
