package com.rosyidgrobogan.moviestoreapitask.movie;

import lombok.Data;

@Data
public class MovieReq
{
    private String title;
    private String synopsis;
    private String genre;
    private Double price;
    private String trailer;
    private String poster;
}
