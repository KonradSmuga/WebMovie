package com.ksmuga.movieweb.domain;

public class MovieDto {

    private Long id;
    private String title;
    private int yearOfProduction;

    public MovieDto(Long id, String title, int yearOfProduction) {
        this.id = id;
        this.title = title;
        this.yearOfProduction = yearOfProduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}

