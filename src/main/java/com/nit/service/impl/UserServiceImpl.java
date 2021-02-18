package com.nit.service.impl;

import com.nit.entity.User;
import com.nit.repository.UserRepository;
import com.nit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        log.info("Saving User.. {}", user.toString());
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
