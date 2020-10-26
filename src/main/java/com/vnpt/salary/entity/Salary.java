package com.vnpt.salary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double allTimesWork;
    private double allDayWork;
    private double wage;
    private double expSalary;
    @Column(name = "user_id")
    private int userId;

    @OneToMany
    @JoinColumn(name = "salary_id", referencedColumnName = "id")
    private List<Bonus>  bonus;
}
