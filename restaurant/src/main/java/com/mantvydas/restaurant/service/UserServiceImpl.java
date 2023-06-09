package com.mantvydas.restaurant.service;

import com.mantvydas.restaurant.mapper.UserMapper;
import com.mantvydas.restaurant.model.User;
import com.mantvydas.restaurant.repo.UserRepository;
import com.mantvydas.restaurant.rest.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User getUserByUsername (String username) {
        return userRepository.findAll().stream().filter(user -> user.getUsername().equals(username)).findAny().orElseThrow();
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserMapper::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersByUsernameFilter (String username) {
        return userRepository.findAll().stream().filter(user -> user.getUsername().contains(username)).map(UserMapper::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public boolean hasUserWithUsername(String username) {
        return userRepository.findAll().stream().anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findAll().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public User validateAndGetUserByUsername(String username) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
