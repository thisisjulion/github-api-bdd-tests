package com.github.api.framework;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class SetupTest {
    @BeforeClass
    public static void setupBaseUrl() {
        String defaultBasePath = System.getProperty("server.host");
        if (defaultBasePath == null) {
            defaultBasePath = "https://api.github.com";
        }
        RestAssured.baseURI = defaultBasePath;
    }
}
