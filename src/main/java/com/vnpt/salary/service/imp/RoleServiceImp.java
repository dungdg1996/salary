package com.vnpt.salary.service.imp;

import com.vnpt.salary.entity.Role;
import com.vnpt.salary.repo.RoleRepo;
import com.vnpt.salary.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepo roleRepo;

    public RoleServiceImp(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }
}
