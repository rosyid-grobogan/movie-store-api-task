package com.rosyidgrobogan.moviestoreapitask.movie;

import com.rosyidgrobogan.moviestoreapitask.data.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository
    extends JpaRepository<Movie, Long>
{
//    List<Movie> findMoviesByUsers();
}
