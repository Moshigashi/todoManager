package com.todo.todomanager.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return (List<User>) users;
    }
    public Optional<User> getUser(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
