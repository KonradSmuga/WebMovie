package com.ksmuga.movieweb.domain;

import com.ksmuga.movieweb.web.rest.dto.MovieDetailsResponse;

import javax.persistence.*;

@Entity(name = "movies")
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String title;

    @Column(name = "yearOfProduction")
    private int yearOfProduction;

    @OneToOne
    private MovieDetailsResponse movieDetailsResponse;

    public Movie() {
    }

    public Movie(String title, int yearOfProduction) {
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

    public MovieDetailsResponse getMovieDetailsResponse(MovieDetailsResponse movieDetailsResponse) {
        return this.movieDetailsResponse;
    }

    public void setMovieDetailsResponse(MovieDetailsResponse movieDetailsResponse) {
        this.movieDetailsResponse = movieDetailsResponse;
    }
}

