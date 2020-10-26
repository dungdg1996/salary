package com.vnpt.salary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String sex;
    private String birthday;
    private String email;
    private String address;
    private String phone;
    private String avatar;
    private double currentSalary;
    private boolean deleted;
    @Column(name = "role_id")
    private int roleId;

    @ManyToOne
    @JoinColumn(name = "role_id", updatable = false, insertable = false)
    private Role role;

    @OneToMany
    @JoinColumn(
            name = "user_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    private List<Record> records;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            updatable = false, insertable = false)
    private List<Salary> salaries;
}
