package com.github.api.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    public static String getGitHubToken() {
        return getConfigProperty(EnvironmentProperty.GITHUB_TOKEN);
    }

    public static String getUsername() {
        return getConfigProperty(EnvironmentProperty.AUTH_BASIC_USERNAME);
    }

    private static String getConfigProperty(EnvironmentProperty environmentProperty) {
        String token = System.getenv(environmentProperty.name());
        if (token == null || token.isEmpty()) {
            token = readTokenFromProperties(environmentProperty);
        }
        return token;
    }

    public static String readTokenFromProperties(EnvironmentProperty environmentProperty) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(CONFIG_PATH)) {
            properties.load(inputStream);
            return properties.getProperty(environmentProperty.name());
        } catch (IOException fileNotFoundException) {
            System.out.println("No config.properties file found");
            return null;
        }
    }
}
