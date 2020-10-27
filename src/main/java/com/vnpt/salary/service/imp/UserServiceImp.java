package com.vnpt.salary.service.imp;

import com.vnpt.salary.entity.User;
import com.vnpt.salary.repo.UserRepo;
import com.vnpt.salary.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteByUserId(int id) {
        Optional<User> userById = userRepo.findById(id);
        if (userById.isPresent()){
            User user = userById.get();
            user.setDeleted(true);
            userRepo.save(user);
        }
    }

    @Override
    public List<User> deletedUser() {
        return userRepo.deletedUsers();
    }

    @Override
    public void restore(int id) {
        Optional<User> userById = userRepo.findById(id);
        if (userById.isPresent()){
            User user = userById.get();
            user.setDeleted(false);
            userRepo.save(user);
        }
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).orElse(new User());
    }

    @Override
    public void update(User user) {
        Optional<User> byId = userRepo.findById(user.getId());
        if (byId.isPresent()){
            userRepo.save(user);
        }
    }
}
