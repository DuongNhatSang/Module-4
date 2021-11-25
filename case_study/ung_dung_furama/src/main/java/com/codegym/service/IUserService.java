package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserService {
    void save(User user);
    User findByUserName(String userName);
    void addUserRole(long userId, long roleId);
    void addUserRole2(long userId, long roleId,long roleId2);
}
