package com.github.api.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data @AllArgsConstructor
public class Repository {
    private Boolean auto_init;
    private String description;
    private String gitignore_template;
    private Boolean has_downloads;
    private Boolean has_issues;
    private Boolean has_wiki;
    private String homepage;
    private String name;
    private String full_name;
    private Boolean isPrivate;
    private Integer team_id;
}
