package com.vnpt.salary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "time_lines")
public class TimeLine {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalTime start;
    private LocalTime end;

    public TimeLine(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }
    public TimeLine(String start, String end) {
        this(LocalTime.parse(start + ":00"), LocalTime.parse(end + ":00"));
    }

    @Override
    public String toString() {
        return start.format(formatter) + "-" + end.format(formatter);
    }
}
