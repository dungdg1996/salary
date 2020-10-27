package com.vnpt.salary.service;

import com.vnpt.salary.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(Integer id);

    void update(Role role);
}
