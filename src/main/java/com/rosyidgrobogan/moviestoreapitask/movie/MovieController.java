package com.rosyidgrobogan.moviestoreapitask.movie;

import com.rosyidgrobogan.moviestoreapitask.data.Movie;
import com.rosyidgrobogan.moviestoreapitask.helpers.errors.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController
{
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<MoviesRes> getAllMovies()
    {
        try {
            MoviesRes data = movieService.getAll();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (RuntimeException e){
            throw new ApiRequestException(e.getMessage());
        }
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieRes> getMovie(@PathVariable("movieId") Long movieId)
    {
        try {
            MovieRes data = movieService.getOne(movieId);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (RuntimeException e){
            throw new ApiRequestException(e.getMessage());
        }

    }
}
