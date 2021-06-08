package com.github.api.framework.datatype;

import com.github.api.framework.model.Repository;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class RepositoryDataType {
    @DataTableType(replaceWithEmptyString = "[blank]")
    public Repository repositoryEntry(Map<String, String> entry) {
        return new Repository(
                entry.containsKey("auto_init") ? Boolean.parseBoolean(entry.get("auto_init")) : null,
                entry.getOrDefault("description", null),
                entry.getOrDefault("gitignore_template", null),
                entry.containsKey("has_downloads") ? Boolean.parseBoolean(entry.get("has_downloads")) : null,
                entry.containsKey("has_issues") ? Boolean.parseBoolean(entry.get("has_issues")) : null,
                entry.containsKey("has_wiki") ? Boolean.parseBoolean(entry.get("has_wiki")) : null,
                entry.getOrDefault("homepage", null),
                entry.getOrDefault("name", null),
                entry.getOrDefault("fullName", null),
                entry.containsKey("isPrivate") ? Boolean.parseBoolean(entry.get("isPrivate")) : null,
                entry.containsKey("team_id") ? Integer.parseInt(entry.get("team_id")) : null);
    }
}
