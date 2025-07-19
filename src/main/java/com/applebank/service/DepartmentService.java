package com.applebank.service;

import java.util.List;

import com.applebank.dto.DepartmentDto;
import com.applebank.model.Department;

public interface DepartmentService {

	public Department registerDepartment(DepartmentDto departmentDto); 
	public Department fetchDepartment(Long id);
	public List<Department> fetchDepartments();
	public Department updateDepartment(Long id,DepartmentDto departmentDto);
	public String deleteDepartment(Long id);
	
}
