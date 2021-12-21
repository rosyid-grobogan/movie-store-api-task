package com.rosyidgrobogan.moviestoreapitask.data;

import com.rosyidgrobogan.moviestoreapitask.data.GenderEnum;
import com.rosyidgrobogan.moviestoreapitask.data.RoleEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String birthday;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private GenderEnum genderEnum;

//    @Enumerated(EnumType.STRING)
//    @Column(length = 20)
    private String role;

//    @ManyToMany(
//            fetch = FetchType.LAZY, cascade = CascadeType.DETACH
//    )
//    @JoinTable(name = "purchases",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
//    )
//    private List<Movie> movies;
    @OneToMany(mappedBy = "user")
    private List<Purchase> users;
}
