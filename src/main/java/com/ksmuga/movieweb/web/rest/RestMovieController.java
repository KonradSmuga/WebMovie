package com.ksmuga.movieweb.web.rest;


import com.ksmuga.movieweb.domain.MovieDto;
import com.ksmuga.movieweb.mapper.MovieMapper;
import com.ksmuga.movieweb.service.MovieService;
import com.ksmuga.movieweb.web.rest.dto.CreateMovieRequest;
import com.ksmuga.movieweb.web.rest.dto.MovieDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class RestMovieController {

    private final MovieService movieService;

    private final MovieMapper movieMapper;

    @Autowired
    public RestMovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public void createMovie(@Valid @RequestBody CreateMovieRequest request) {
        movieService.createMovie(request);
    }

    @GetMapping
    public List<MovieDto> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(path = "/{id}/details")
    public MovieDetailsResponse getMovieDetails(@PathVariable("id") Long movieId) {
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMovie(@PathVariable("id") Long movieId ) throws MovieNotFoundException{
        movieService.deleteById(movieId);
    }

    @GetMapping(path = "/{id}")
    public MovieDto getMovieId(@PathVariable("id") Long movieId) throws MovieNotFoundException {
        return movieMapper.mapToMovieDto(movieService.findById(movieId).orElseThrow(MovieNotFoundException::new));

    }
    @GetMapping(value = "/list")
    public Page<MovieDto> getMovies(Pageable page)
    {
      return   movieService.getMovies(page);
    }

}
