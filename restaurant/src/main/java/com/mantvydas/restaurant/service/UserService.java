package com.mantvydas.restaurant.service;

import com.mantvydas.restaurant.model.User;
import com.mantvydas.restaurant.rest.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    List<UserDto> getUsersByUsernameFilter(String username);

    User getUserByUsername(String username);

    boolean hasUserWithUsername(String username);

    boolean hasUserWithEmail(String email);

    User validateAndGetUserByUsername(String username);

    User saveUser(User user);

    void deleteUser(User user);
}
