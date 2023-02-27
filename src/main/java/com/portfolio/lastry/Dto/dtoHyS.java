package com.portfolio.lastry.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHyS {
    @NotBlank
    private String name;
    @NotBlank
    private int time;

    // Constructor
    public dtoHyS() {
    }

    public dtoHyS(String name, int time) {
        this.name = name;
        this.time = time;
    }

    // Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
