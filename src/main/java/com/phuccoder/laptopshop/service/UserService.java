package com.phuccoder.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phuccoder.laptopshop.domain.User;
import com.phuccoder.laptopshop.repository.UserRepository;

@Service
public class UserService {
    // biến
    final UserRepository userRepository;

    // constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // method save
    public User save(User user) {
        return this.userRepository.save(user);
    }

    // method find all
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    // method get a user by id
    public User getaUser(long id) {
        return this.userRepository.findById(id);
    }

    // method delete a user by id
    public void delete(long id) {
        this.userRepository.deleteById(id);
    }

    // method update a user
    public User update(User user) {
        return this.userRepository.save(user);
    }
}
