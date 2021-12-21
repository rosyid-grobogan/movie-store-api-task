package com.rosyidgrobogan.moviestoreapitask.movie;

import com.rosyidgrobogan.moviestoreapitask.data.Movie;
import com.rosyidgrobogan.moviestoreapitask.data.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRes
{
    private String code;
    private String message;
    private Optional<Movie> data;
}
