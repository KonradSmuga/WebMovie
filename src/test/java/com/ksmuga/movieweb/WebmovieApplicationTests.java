package com.ksmuga.movieweb;

import com.ksmuga.movieweb.domain.Movie;
import com.ksmuga.movieweb.domain.MovieDto;
import com.ksmuga.movieweb.mapper.MovieMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebmovieApplicationTests {

	@InjectMocks
	private MovieMapper movieMapper;

	@Test
	public void testMovieMapper() {
		//Given

		Movie movie = new Movie("testTitle", 1990);
		List<Movie> movies = Arrays.asList(movie);

		//When
		MovieDto mapToMovieDto = movieMapper.mapToMovieDto(movie);
		List<MovieDto> mapToMovieDtoList = movieMapper.mapToMovieDtoList(movies);
		Movie mapToTask = movieMapper.mapToMovie(mapToMovieDto);

		//Then
		Assert.assertEquals("testTitle", mapToMovieDto.getTitle());
		Assert.assertEquals("testTitle", mapToMovieDtoList.get(0).getTitle());
		Assert.assertEquals(1990, mapToMovieDto.getYearOfProduction());
	}
}
