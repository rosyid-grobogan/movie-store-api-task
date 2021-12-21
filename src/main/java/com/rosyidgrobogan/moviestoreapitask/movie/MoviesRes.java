package com.rosyidgrobogan.moviestoreapitask.movie;

import com.rosyidgrobogan.moviestoreapitask.data.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesRes
{
    private String code;
    private String message;
    private List<Movie> data;
}
