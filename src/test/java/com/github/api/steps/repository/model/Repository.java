package com.github.api.steps.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public Repository(Boolean auto_init, String description, String gitignore_template, Boolean has_downloads,
                      Boolean has_issues, Boolean has_wiki, String homepage, String name, String full_name,
                      Boolean isPrivate, Integer team_id) {
        this.auto_init = auto_init;
        this.description = description;
        this.gitignore_template = gitignore_template;
        this.has_downloads = has_downloads;
        this.has_issues = has_issues;
        this.has_wiki = has_wiki;
        this.homepage = homepage;
        this.name = name;
        this.full_name = full_name;
        this.isPrivate = isPrivate;
        this.team_id = team_id;
    }

    public Repository() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(has_downloads, that.has_downloads) &&
                Objects.equals(has_issues, that.has_issues) &&
                Objects.equals(has_wiki, that.has_wiki) &&
                Objects.equals(homepage, that.homepage) &&
                Objects.equals(name, that.name) &&
                Objects.equals(full_name, that.full_name) &&
                Objects.equals(isPrivate, that.isPrivate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, has_downloads, has_issues, has_wiki, homepage, name, full_name, isPrivate);
    }

    @Override
    public String toString() {
        return "Repository{" +
                ", auto_init=" + auto_init +
                ", description='" + description + '\'' +
                ", gitignore_template='" + gitignore_template + '\'' +
                ", has_downloads=" + has_downloads +
                ", has_issues=" + has_issues +
                ", has_wiki=" + has_wiki +
                ", homepage='" + homepage + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + full_name + '\'' +
                ", isPrivate=" + isPrivate +
                ", team_id=" + team_id +
                '}';
    }

    public Boolean getAuto_init() {
        return auto_init;
    }

    public void setAuto_init(Boolean auto_init) {
        this.auto_init = auto_init;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGitignore_template() {
        return gitignore_template;
    }

    public void setGitignore_template(String gitignore_template) {
        this.gitignore_template = gitignore_template;
    }

    public Boolean getHas_downloads() {
        return has_downloads;
    }

    public void setHas_downloads(Boolean has_downloads) {
        this.has_downloads = has_downloads;
    }

    public Boolean getHas_issues() {
        return has_issues;
    }

    public void setHas_issues(Boolean has_issues) {
        this.has_issues = has_issues;
    }

    public Boolean getHas_wiki() {
        return has_wiki;
    }

    public void setHas_wiki(Boolean has_wiki) {
        this.has_wiki = has_wiki;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

}
