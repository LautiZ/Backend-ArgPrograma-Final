package com.portfolio.lastry.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducation {
    @NotBlank
    private String titleEd;
    @NotBlank
    private String descriptionEd;

    //Constructors
    public dtoEducation() {
    }

    public dtoEducation(String titleEd, String descriptionEd) {
        this.titleEd = titleEd;
        this.descriptionEd = descriptionEd;
    }

    // Getters y Setters
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
