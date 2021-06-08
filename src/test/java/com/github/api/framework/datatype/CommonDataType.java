package com.github.api.framework.datatype;

import com.github.api.framework.model.ErrorResponse;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CommonDataType {

    @DataTableType
    public ErrorResponse.Error errorEntry(Map<String, String> entry) {
        return new ErrorResponse.Error(entry.getOrDefault("field", null),
                entry.getOrDefault("code", null));
    }
}
