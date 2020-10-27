package com.vnpt.salary.service.imp;

import com.vnpt.salary.entity.Role;
import com.vnpt.salary.repo.RoleRepo;
import com.vnpt.salary.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Role findById(Integer id) {
        return roleRepo.findById(id).orElseGet(Role::new);
    }

    @Override
    public void update(Role role) {
        Optional<Role> byId = roleRepo.findById(role.getId());
        if (byId.isPresent()){
            Role newRole = byId.get();
            newRole.setDescription(role.getDescription());
            roleRepo.save(role);
        }
    }
}
