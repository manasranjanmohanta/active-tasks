package com.example.primary.repo;

import com.example.primary.entity.PrimaryEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryEmployeeRepository extends JpaRepository<PrimaryEmployee, Long> {
}
