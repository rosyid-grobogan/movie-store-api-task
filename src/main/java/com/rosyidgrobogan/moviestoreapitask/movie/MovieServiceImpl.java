package com.rosyidgrobogan.moviestoreapitask.movie;

import com.rosyidgrobogan.moviestoreapitask.data.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl
    implements MovieService
{
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }


    @Override
    public MoviesRes getAll()
    {
        List<Movie> movies = movieRepository.findAll();
        MoviesRes dataRes = new MoviesRes("200", "success", movies);

        return dataRes;
    }

    @Override
    public MovieRes getOne(Long movieId)
    {
         Optional<Movie> movie = movieRepository.findById(movieId);
         MovieRes dataRes = new MovieRes("200", "success", movie);

         return dataRes;
    }


}
