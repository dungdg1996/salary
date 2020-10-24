package com.vnpt.salary.entity;

import com.sun.xml.bind.v2.model.core.ID;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Record> records;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Salary> salaries;
}
