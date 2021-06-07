package com.github.api.framework.extensions;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class RestAssuredExtensions {
    private static final String AUTH_USERNAME_ENV_VAR = "AUTH_BASIC_USERNAME";
    private static final String AUTH_TOKEN_ENV_VAR = "AUTH_BASIC_TOKEN";

    public static RequestSpecification givenUserBasicAuthorization() {
        return givenUserBasicAuthorization(System.getenv(AUTH_USERNAME_ENV_VAR), System.getenv(AUTH_TOKEN_ENV_VAR));
    }

    public static RequestSpecification givenUserBasicAuthorization(String username, String token) {
        return given().auth().preemptive().basic(username, token);
    }
}
