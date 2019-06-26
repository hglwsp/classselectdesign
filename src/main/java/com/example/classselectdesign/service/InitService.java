package com.example.classselectdesign.service;

import com.example.classselectdesign.entity.User;
import com.example.classselectdesign.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
public class InitService implements InitializingBean {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setAuthority(User.Mannager_AUTHORITY);
            user.setNumber("1001");
            user.setPassword(passwordEncoder.encode(user.getNumber()));
            user.setName("wsp");
            userRepository.save(user);
        }
    }
}