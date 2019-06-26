package com.example.classselectdesign.service;

import com.example.classselectdesign.entity.User;
import com.example.classselectdesign.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(String number) {
        return userRepository.find(number);
    }
}