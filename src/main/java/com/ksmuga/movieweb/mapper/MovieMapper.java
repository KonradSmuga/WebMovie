package com.ksmuga.movieweb.mapper;


import com.ksmuga.movieweb.domain.Movie;
import com.ksmuga.movieweb.domain.MovieDto;
import com.ksmuga.movieweb.web.rest.dto.CreateMovieRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    public Movie mapToMovie(MovieDto movieDto) {
        return new Movie(
                movieDto.getTitle(),
                movieDto.getYearOfProduction());
    }

    public Movie mapToMovie(CreateMovieRequest movieRequest) {
        return new Movie(movieRequest.getTitle(),
                movieRequest.getYearOfProduction());
    }

    public MovieDto mapToMovieDto(final Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getYearOfProduction()
        );
    }

    public List<MovieDto> mapToMovieDtoList(final List<Movie> movieList) {

        return movieList.stream()
                .map(t -> new MovieDto(t.getId(), t.getTitle(), t.getYearOfProduction()))
                .collect(Collectors.toList());
    }
}

