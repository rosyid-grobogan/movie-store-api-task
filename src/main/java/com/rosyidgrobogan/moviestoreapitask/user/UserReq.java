package com.rosyidgrobogan.moviestoreapitask.user;

import com.rosyidgrobogan.moviestoreapitask.data.GenderEnum;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserReq
{
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @NotBlank
    private String birthday;

    @NotNull
    private GenderEnum gender;
}
