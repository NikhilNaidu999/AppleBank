package com.applebank.service;

import java.util.List;

import com.applebank.dto.EmployeeDto;
import com.applebank.model.Employee;
import com.applebank.update.dto.EmpUpdateDto;

public interface EmployeeService {

	public Employee registerEmployee(EmployeeDto employeeDto); 
	public Employee fetchEmployee(Long id);
	public List<Employee> fetchEmployees();
	public Employee updateEmployee(Long id,EmpUpdateDto empUpdateDto);
	public String deleteEmployee(Long id);
}
