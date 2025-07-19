package com.applebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applebank.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
