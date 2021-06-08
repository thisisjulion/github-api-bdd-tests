package com.github.api.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    private String message;
    private List<Error> errors;

    public ErrorResponse(String message, List<Error> errors) {
        this.message = message;
        this.errors = errors;
    }

    public ErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public List<Error> getErrors() {
        return errors;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        private String field;
        private String code;

        public Error(String field, String code) {
            this.field = field;
            this.code = code;
        }

        public Error() {
        }

        public String getField() {
            return field;
        }

        public String getCode() {
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Error error = (Error) o;
            return Objects.equals(field, error.field) &&
                    Objects.equals(code, error.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(field, code);
        }

        @Override
        public String toString() {
            return "Error{" +
                    "field='" + field + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }
}
