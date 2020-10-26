package com.vnpt.salary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private double workTimes;
    private double eatTimes;
    @Column(name = "user_id")
    private int userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id", referencedColumnName = "id")
    private List<TimeLine> timeLines;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
