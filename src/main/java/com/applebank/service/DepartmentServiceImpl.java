package com.applebank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applebank.dto.DepartmentDto;
import com.applebank.exception.DepartmentNotFoundException;
import com.applebank.model.Department;
import com.applebank.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department registerDepartment(DepartmentDto departmentDto) {
		Department department=Department.builder()
		.name(departmentDto.getName())
		.build();
		departmentRepository.save(department);
		return department;
	}

	@Override
	public Department fetchDepartment(Long id) {
		Department department=departmentRepository.findById(id)
		.orElseThrow(()->new DepartmentNotFoundException("Department With Id :"+id+"NOT_FOUND"));
		return department;
	}

	@Override
	public List<Department> fetchDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Long id, DepartmentDto departmentDto) {
		Department department=departmentRepository.findById(id)
				.orElseThrow(()->new DepartmentNotFoundException("Department With Id :"+id+"NOT_FOUND"));
		department.setName(departmentDto.getName());
		departmentRepository.save(department);
		return department;
	}

	@Override
	public String deleteDepartment(Long id) {
		Department department=departmentRepository.findById(id)
				.orElseThrow(()->new DepartmentNotFoundException("Department With Id :"+id+"NOT_FOUND"));
		departmentRepository.delete(department);
		return "Department With Id :"+id+"Deleted SuccessFully";
	}

}
