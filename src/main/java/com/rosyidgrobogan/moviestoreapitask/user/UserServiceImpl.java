package com.rosyidgrobogan.moviestoreapitask.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
    implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserReq req)
    {

        User user = new User();

        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setFullName(req.getFullName());
        user.setBirthday(req.getBirthday());
        user.setGenderEnum(req.getGender());
        user.setRole(RoleEnum.ROLE_USER);

        userRepository.save(user);
    }
}
