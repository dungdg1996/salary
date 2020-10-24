package com.vnpt.salary.repo;

import com.vnpt.salary.entity.Record;
import com.vnpt.salary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepo extends JpaRepository<Record, Integer> {
}
