package com.github.api.framework.service;

import com.github.api.framework.extension.RestAssuredExtension;
import io.restassured.response.ValidatableResponse;

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
        return RestAssuredExtension.login().body(objectToCreate)
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
        return RestAssuredExtension.login()
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
        return RestAssuredExtension.login().body(objectToUpdate)
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
        return RestAssuredExtension.login()
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
