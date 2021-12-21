package com.rosyidgrobogan.moviestoreapitask.user;

import com.rosyidgrobogan.moviestoreapitask.auth.CustomUserDetailsService;
import com.rosyidgrobogan.moviestoreapitask.auth.JwtRequest;
import com.rosyidgrobogan.moviestoreapitask.auth.JwtResponse;
import com.rosyidgrobogan.moviestoreapitask.auth.Token;
import com.rosyidgrobogan.moviestoreapitask.helpers.errors.ApiRequestException;
import com.rosyidgrobogan.moviestoreapitask.helpers.jwt.JwtUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController
{
    private final UserService userService;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtility jwtUtility;
    private final AuthenticationManager authenticationManager;

    public UserController(
            UserService userService,
                          CustomUserDetailsService userDetailsService,
                          JwtUtility jwtUtility, AuthenticationManager authenticationManager)
    {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(
                                             @RequestBody JwtRequest jwtRequest)
            throws Exception
    {
        Token dataToken = new Token();
        dataToken.setToken(null);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getEmail(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS ", e);

            //JwtResponse dataResponse = new JwtResponse("300", "invalid", new Token());


            // return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());

        final String token = jwtUtility.generateToken(userDetails);

        dataToken.setToken(token);
        JwtResponse dataResponse = new JwtResponse("200", "success", dataToken);

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
//        return new JwtResponse(token);
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
