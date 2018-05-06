package com.ksmuga.movieweb.web.rest.dto;

import com.ksmuga.movieweb.domain.Movie;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Table(name = "MovieDetails")
public class MovieDetailsResponse {
    private int id;
    private String genre;
    private String directorName;
    private String production;
    private BigDecimal boxOffice;
    private Movie movie;

    public MovieDetailsResponse() {
    }

    public MovieDetailsResponse(String genre, String directorName, String production, BigDecimal boxOffice, Movie movie) {

        this.genre = genre;
        this.directorName = directorName;
        this.production = production;
        this.boxOffice = boxOffice;
        this.movie = movie;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "GENRE")
    public String getGenre() {
        return genre;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "DIRECTOR_NAME")
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Column(name = "PRODCUTION")
    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Column(name = "BOX_OFFICE")
    public BigDecimal getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(BigDecimal boxOffice) {
        this.boxOffice = boxOffice;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}