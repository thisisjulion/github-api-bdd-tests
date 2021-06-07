package com.github.api.steps.common.actions;

import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.github.api.framework.extensions.RestAssuredExtensions.givenUserBasicAuthorization;

public class BaseActions {
    public static SoftAssertions softAssertions = new SoftAssertions();

    /**
     * POST request with possibility to provide path and object to be created
     * Object will be serialized to JSON
     *
     * @param path           path
     * @param objectToCreate object to create
     * @return ValidatableResponse the response
     */
    protected ValidatableResponse create(String path, Object objectToCreate) {
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
    protected ValidatableResponse read(String path) {
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
    protected ValidatableResponse patch(String path, Object objectToUpdate) {
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
    protected ValidatableResponse delete(String path) {
        return givenUserBasicAuthorization()
                .when().delete(path)
                .then();
    }

    public <T> void verifyObject(T expectedObject, T actualObject) {
        softAssertions.assertThat(actualObject).isEqualTo(expectedObject);
    }

    public <T> void verifyListOfObjects(List<T> expectedList, List<T> actualList) {
        softAssertions.assertThat(actualList).isEqualTo(expectedList);
    }

    public void verifyStatusCode(ValidatableResponse validatableResponse, int expectedStatusCode) {
        softAssertions.assertThat(validatableResponse.extract().statusCode()).isEqualTo(expectedStatusCode);
    }

    protected <T> T getObjectFromResponse(ValidatableResponse validatableResponse,
                                          Class<T> clazz) {
        return validatableResponse.extract().body().as(clazz);
    }
}
