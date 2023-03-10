package com.management.system.repository;

import com.management.system.model.Records;
import com.management.system.model.RecordsId;
import com.management.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordsRepository extends JpaRepository<Records, RecordsId> {
}

