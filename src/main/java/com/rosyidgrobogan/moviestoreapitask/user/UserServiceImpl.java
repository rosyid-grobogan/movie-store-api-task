package com.rosyidgrobogan.moviestoreapitask.user;

import com.rosyidgrobogan.moviestoreapitask.data.RoleEnum;
import com.rosyidgrobogan.moviestoreapitask.data.User;
import com.rosyidgrobogan.moviestoreapitask.helpers.errors.ApiRequestException;
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
    public UserRes createUser(UserReq req)
    {

        // isEmail Taken
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new ApiRequestException(req.getEmail() + " is taken");
        }

        User user = new User();

        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setFullName(req.getFullName());
        user.setBirthday(req.getBirthday());
        user.setGenderEnum(req.getGender());
        user.setRole(RoleEnum.ROLE_USER);

        userRepository.save(user);
        UserRes dataRes = new UserRes("201", "success", user);

        return dataRes;
    }
}
