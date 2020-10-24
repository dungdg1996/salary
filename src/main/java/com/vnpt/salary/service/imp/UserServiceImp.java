package com.vnpt.salary.service.imp;

import com.vnpt.salary.entity.User;
import com.vnpt.salary.repo.UserRepo;
import com.vnpt.salary.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
