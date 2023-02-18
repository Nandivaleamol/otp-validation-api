package com.otp.validation.service;

import com.otp.validation.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    // adding new user
    User createUser(User user);

    //get user by user id
    User getUserById(Integer userId);

    //get all users
    List<User> getAllUsers();

//
//    //update user by user id
//    User updateUser(User user, Integer userId);
//
//    //delete user by user id
//    void deleteUser(Integer userId);


}
