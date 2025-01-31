package com.phuccoder.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phuccoder.laptopshop.domain.User;
import com.phuccoder.laptopshop.repository.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User getaUser(long id) {
        return this.userRepository.findById(id);
    }
}
