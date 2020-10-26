package com.vnpt.salary.controller;

import com.vnpt.salary.entity.Role;
import com.vnpt.salary.entity.User;
import com.vnpt.salary.service.RoleService;
import com.vnpt.salary.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/user-index";
    }

    @GetMapping("deleted")
    public String deletedUser(Model model){
        model.addAttribute("users", userService.deleteUsers());
        return "user/user-deleted";
    }

    @GetMapping("create")
    public String createPage(Model model){
        User newUser = new User();
        newUser.setRoleId(Role.USER.getId());
        model.addAttribute("user", newUser);
        model.addAttribute("roles", roleService.findAll());
        return "user/user-add";
    }

    @PostMapping("create")
    public String creat(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        userService.deleteByUserId(id);
        return "redirect:/users";
    }

    @GetMapping("/restore")
    public String restore(@RequestParam int id){
        userService.restore(id);
        return "redirect:/users/deleted";
    }
}
