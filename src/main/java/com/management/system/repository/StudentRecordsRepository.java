package com.management.system.repository;

import com.management.system.model.StudentRecords;
import com.management.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRecordsRepository extends JpaRepository<StudentRecords, Integer> {
    List<StudentRecords> findByUser(User user);
}
