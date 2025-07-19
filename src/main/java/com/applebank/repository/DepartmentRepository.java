package com.applebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applebank.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
