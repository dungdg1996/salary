package com.vnpt.salary.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "status")
public class Status {
    public static final String NO_WORK = "NO_WORK";
    public static final String WAIT_TO_EDIT = "WAIT_TO_EDIT";
    public static final String EDITED = "EDITED";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
}
