package com.portfolio.lastry.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 255, message = "Titulo demasiado largo")
    private String title;

    @NotNull
    @Size(min = 1, max = 255, message = "Titulo demasiado largo")
    private String subtitle;

    @NotNull
    @Column(name = "text", columnDefinition="TEXT")
    private String description;

    @NotNull
    @Column(name = "imgProjectURL", columnDefinition="TEXT")
    private String imgProject;

    private String linkProject;

    // Constructors
    public Projects() {
    }

    public Projects(String title, String subtitle, String description, String imgProject, String linkProject) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.imgProject = imgProject;
        this.linkProject = linkProject;
    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
