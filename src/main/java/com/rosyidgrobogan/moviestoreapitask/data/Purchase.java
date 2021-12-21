package com.rosyidgrobogan.moviestoreapitask.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "purchases")
public class Purchase
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
}
