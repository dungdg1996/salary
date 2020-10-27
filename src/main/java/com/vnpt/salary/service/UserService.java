package com.vnpt.salary.service;

import com.vnpt.salary.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    void deleteByUserId(int id);

    List<User> deletedUser();

    void restore(int id);

    User findById(int id);

    void update(User user);

}
