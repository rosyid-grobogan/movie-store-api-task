package com.rosyidgrobogan.moviestoreapitask.auth;


import com.rosyidgrobogan.moviestoreapitask.data.User;
import com.rosyidgrobogan.moviestoreapitask.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
    implements UserDetailsService
{
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {
        User user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(user);
        //return new User("admin", "rahasia", new ArrayList<>());
    }
}
