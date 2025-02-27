package com.github.api.framework;

import io.restassured.RestAssured;
import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.BeforeClass;

public class SetupTest {
    private static final EnvironmentVariables environmentVariables = ConfiguredEnvironment.getEnvironmentVariables();

    @BeforeClass
    public static void setupBaseUrl() {
        RestAssured.baseURI = environmentVariables.getProperty("serenity.restApi.baseUrl");
    }
}