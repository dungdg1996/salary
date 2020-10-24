package com.vnpt.salary.service.imp;

import com.vnpt.salary.entity.User;
import com.vnpt.salary.repo.UserRepo;
import com.vnpt.salary.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImpAuthService implements AuthService {
    private final UserRepo userRepo;
    private User user;

    public ImpAuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Optional<User> byUsername = userRepo.findByUsername(username);
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            if (user.getPassword().equals(password)) {
                this.user = user;
                return true;
            }
        }
        return false;
    }

    @Override
    public User getPrincipal() {
        return this.user;
    }
}
