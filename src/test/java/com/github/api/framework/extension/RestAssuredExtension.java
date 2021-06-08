package com.github.api.framework.extension;

import com.github.api.framework.config.Configuration;
import com.github.api.framework.config.EnvironmentProperty;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class RestAssuredExtension {

    public static RequestSpecification givenUserBasicAuthorization() {
        return givenUserBasicAuthorization(
                Configuration.getConfigProperty(EnvironmentProperty.AUTH_BASIC_USERNAME),
                Configuration.getConfigProperty(EnvironmentProperty.AUTH_BASIC_TOKEN)
        );
    }

    public static RequestSpecification givenUserBasicAuthorization(String username, String token) {
        return given().auth().preemptive().basic(username, token);
    }
}
