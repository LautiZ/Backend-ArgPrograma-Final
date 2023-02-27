package com.portfolio.lastry.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titleEd;

    private String descriptionEd;

    // Constructors
    public Education() {
    }

    public Education(String titleEd, String descriptionEd) {
        this.titleEd = titleEd;
        this.descriptionEd = descriptionEd;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleEd() {
        return titleEd;
    }

    public void setTitleEd(String titleEd) {
        this.titleEd = titleEd;
    }

    public String getDescriptionEd() {
        return descriptionEd;
    }

    public void setDescriptionEd(String descriptionEd) {
        this.descriptionEd = descriptionEd;
    }
}
