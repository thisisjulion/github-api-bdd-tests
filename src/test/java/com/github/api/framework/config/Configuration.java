package com.github.api.framework.config;

import java.util.Optional;

public class Configuration {

    public static String getConfigProperty(EnvironmentProperty property) {
        return getConfigProperty(property.name());
    }

    public static String getConfigPropertyOrDefault(EnvironmentProperty property, String defaultValue) {
        return getConfigPropertyOrDefault(property.name(), defaultValue);
    }

    public static String getConfigProperty(String name) {
        return System.getenv(name);
    }

    public static String getConfigPropertyOrDefault(String name, String defaultValue) {
        return Optional.ofNullable(getConfigProperty(name)).orElse(defaultValue);
    }
}
