package com.portfolio.lastry.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProjects {
    @NotBlank
    private String title;
    @NotBlank
    private String subtitle;
    @NotBlank
    private String description;

    @NotBlank
    private String imgProject;

    private String linkProject;

    // Constructors
    public dtoProjects() {
    }

    public dtoProjects(String title, String subtitle, String description, String imgProject, String linkProject) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.imgProject = imgProject;
        this.linkProject = linkProject;
    }

    // Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgProject() {
        return imgProject;
    }

    public void setImgProject(String imgProject) {
        this.imgProject = imgProject;
    }

    public String getLinkProject() {
        return linkProject;
    }

    public void setLinkProject(String linkProject) {
        this.linkProject = linkProject;
    }
}
