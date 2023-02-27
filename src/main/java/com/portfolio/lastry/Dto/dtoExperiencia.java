package com.portfolio.lastry.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String titleE;

    @NotBlank
    private String descriptionE;

    // Constructor
    public dtoExperiencia() {
    }

    public dtoExperiencia(String titleE, String descriptionE) {
        this.titleE = titleE;
        this.descriptionE = descriptionE;
    }

    // Getters y Setters

    public String getTitleE() {
        return titleE;
    }

    public void setTitleE(String titleE) {
        this.titleE = titleE;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }
}
