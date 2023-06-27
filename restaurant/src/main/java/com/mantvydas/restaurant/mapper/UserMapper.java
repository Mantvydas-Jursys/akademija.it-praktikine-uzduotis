package com.mantvydas.restaurant.mapper;

import com.mantvydas.restaurant.model.User;
import com.mantvydas.restaurant.rest.dto.UserDto;

public class UserMapper {

    public static UserDto userToUserDto (User userToConvert) {
        return new UserDto(
                userToConvert.getId(),
                userToConvert.getUsername(),
                userToConvert.getPassword(),
                userToConvert.getName(),
                userToConvert.getEmail(),
                userToConvert.getRole()
                );
    }
}
