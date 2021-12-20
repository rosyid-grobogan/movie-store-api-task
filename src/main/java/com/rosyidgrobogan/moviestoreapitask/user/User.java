package com.rosyidgrobogan.moviestoreapitask.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String birthday;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private GenderEnum genderEnum;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum role;
}
