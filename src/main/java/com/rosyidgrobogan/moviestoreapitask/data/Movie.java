package com.rosyidgrobogan.moviestoreapitask.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "movies")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie
    implements Serializable
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

//    @ManyToMany(
//            fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "movies"
//    )
//    private List<User> users;
    @OneToMany(mappedBy = "movie")
    private List<Purchase> movies;
}
