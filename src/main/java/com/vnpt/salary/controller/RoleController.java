package com.vnpt.salary.controller;

import com.vnpt.salary.entity.Role;
import com.vnpt.salary.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String roleList(Model model){
        model.addAttribute("roles", roleService.findAll());
        return "role/role-index";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam Integer id){
        model.addAttribute("role", roleService.findById(id));
        return "role/role-edit";
    }

    @PostMapping("update")
    public String update(Role role){
        roleService.update(role);
        return "redirect:/roles";
    }
}
