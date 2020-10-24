package com.vnpt.salary;

import com.vnpt.salary.entity.Role;
import com.vnpt.salary.repo.RoleRepo;
import javafx.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalaryApplication {

    public static void main(String[] args) {
        Application.launch(SalaryUIApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleRepo roleRepo){
        return args -> {
            roleRepo.save(new Role(1, "ADMIN", "Quản trị hệ thống "));
        };
    }

}