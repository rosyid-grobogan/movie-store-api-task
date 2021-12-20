package com.rosyidgrobogan.moviestoreapitask.user;

import com.rosyidgrobogan.moviestoreapitask.helpers.errors.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserRes> signup(
            @RequestBody @Valid UserReq req
    )
    {
        try {
            UserRes data = userService.createUser(req);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (RuntimeException e) {
            throw new ApiRequestException(e.getMessage());
        }
    }
}
