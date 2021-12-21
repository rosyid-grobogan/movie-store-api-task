package com.rosyidgrobogan.moviestoreapitask.movie;

public interface MovieService
{
    MoviesRes getAll();

    MovieRes getOne(Long movieId);
}
