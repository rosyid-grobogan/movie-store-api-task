package com.rosyidgrobogan.moviestoreapitask.data;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "movies")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String synopsis;
    private String genre;
    private Double price;
    private String trailer;
    private String poster;

    @ManyToMany(
            fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movies"
    )
    private List<User> users;
}
