package com.github.api.framework.extension;

import com.github.api.framework.config.Configuration;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestAssuredExtension {

    public static RequestSpecification login() {
        return loginAs(Configuration.getUsername(), Configuration.getGitHubToken()
        );
    }

    public static RequestSpecification loginAs(String username, String token) {
        return given().auth().preemptive().basic(username, token);
    }
}
