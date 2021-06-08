package com.github.api.framework;

import com.github.api.framework.config.Configuration;
import com.github.api.framework.config.EnvironmentProperty;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class SetupTest {
    private static final String DEFAULT_API_PATH = "https://api.github.com";

    @BeforeClass
    public static void setupBaseUrl() {
        RestAssured.baseURI = Configuration.getConfigPropertyOrDefault(
                EnvironmentProperty.API_BASE_URI,
                DEFAULT_API_PATH
        );
    }
}
