package com.ksmuga.movieweb.service;

import com.ksmuga.movieweb.domain.Movie;
import com.ksmuga.movieweb.domain.MovieDto;
import com.ksmuga.movieweb.mapper.MovieMapper;
import com.ksmuga.movieweb.repository.MovieRepository;
import com.ksmuga.movieweb.web.rest.dto.CreateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

   public void createMovie(CreateMovieRequest createMovieRequest) {
      Movie movie = movieMapper.mapToMovie(createMovieRequest);
      movieRepository.save(movie);
   }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movieMapper::mapToMovieDto)
                .collect(Collectors.toList());
    }

    public Optional<Movie> findById(final Long movieId) {

        return movieRepository.findById(movieId);
    }

    public void deleteById(final Long movieId) {

        movieRepository.deleteById(movieId);
    }

    public Page<MovieDto> getMovies(Pageable pageable){
        Page<Movie> page = movieRepository.findAll(pageable);
        return  page.map(movieMapper::mapToMovieDto);
    }


}

