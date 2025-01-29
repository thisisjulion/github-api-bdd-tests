package com.github.api;

import com.github.api.framework.SetupTest;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        glue = {"com.github.api.stepdefinition.repository", "com.github.api.framework.datatype"},
        features = {"src/test/resources/com.github.api.features.repository"}
)
public class TestRunner extends SetupTest {
}
