package com.github.api.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data @AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<Error> errors;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data(staticConstructor="of") @AllArgsConstructor
    public static class Error {
        private String field;
        private String code;
    }
}
