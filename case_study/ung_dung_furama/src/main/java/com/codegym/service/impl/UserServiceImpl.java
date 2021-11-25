package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void addUserRole(long userId, long roleId) {
         userRepository.addUserRole(userId, roleId);
    }

    @Override
    public void addUserRole2(long userId, long roleId, long roleId2) {
        userRepository.addUserRole2(userId,roleId,roleId2);
    }
}
