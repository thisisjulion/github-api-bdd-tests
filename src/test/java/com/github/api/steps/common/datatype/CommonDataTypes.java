package com.github.api.steps.common.datatype;

import com.github.api.steps.common.model.ErrorResponse;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CommonDataTypes {

    @DataTableType
    public ErrorResponse.Error errorEntry(Map<String, String> entry) {
        return new ErrorResponse.Error(entry.getOrDefault("field", null),
                entry.getOrDefault("code", null));
    }
}
