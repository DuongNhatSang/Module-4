package com.codegym.service.impl;

import com.codegym.model.Role;
import com.codegym.repository.IRoleRepository;
import com.codegym.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
