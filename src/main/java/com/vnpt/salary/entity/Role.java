package com.vnpt.salary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    public final static Role ADMIN = new Role(1, "ROLE_ADMIN", "Quản trị hệ thống");
    public final static Role LEADER = new Role(2, "ROLE_LEADER", "Trưởng nhóm");
    public final static Role USER = new Role(3, "ROLE_USER", "Nhân viên");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
}
