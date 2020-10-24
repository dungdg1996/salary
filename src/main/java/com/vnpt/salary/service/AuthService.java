package com.vnpt.salary.service;

import com.vnpt.salary.entity.User;


public interface AuthService {
    boolean checkLogin(String username, String password);
    User getPrincipal();
}
