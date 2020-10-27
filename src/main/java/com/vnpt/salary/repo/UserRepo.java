package com.vnpt.salary.repo;

import com.vnpt.salary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Override
    @Query("select u from User u where u.deleted = false")
    List<User> findAll();
    @Query("select u from User u where u.deleted = true")
    List<User> deletedUsers();

    Optional<User> findByUsername(String username);

}
