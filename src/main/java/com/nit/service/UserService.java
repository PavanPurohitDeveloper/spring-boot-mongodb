package com.nit.service;

import com.nit.entity.User;

import java.util.List;

public interface UserService {

    //create a new User
    User createUser(User user);

    //Getting a user by ID
    User getUser(String userId);

    //Delete the User
    void deleteUser(String userId);

    //Get All the Users
    List<User> getAllUsers();

    //Add or Update user setting

}
