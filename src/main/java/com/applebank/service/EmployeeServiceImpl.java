package com.applebank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applebank.dto.EmployeeDto;
import com.applebank.exception.EmployeeNotFoundException;
import com.applebank.model.Employee;
import com.applebank.repository.EmployeeRepository;
import com.applebank.update.dto.EmpUpdateDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee registerEmployee(EmployeeDto employeeDto) {
		Employee employee = Employee.builder().firstName(employeeDto.getFirstName())
				.middelName(employeeDto.getMiddelName()).lastName(employeeDto.getLastName())
				.dateOfBirth(employeeDto.getDateOfBirth()).gender(employeeDto.getGender())
				.joiningDate(employeeDto.getJoiningDate()).leavingDate(employeeDto.getJoiningDate())
				.status(employeeDto.getStatus()).location(employeeDto.getLocation()).build();
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Employee fetchEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee With Id :" + id + "NOT_FOUND"));
		return employee;
	}

	@Override
	public List<Employee> fetchEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Long id, EmpUpdateDto empUpdateDto) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee With Id :" + id + "NOT_FOUND"));

		employee.builder().lastName(empUpdateDto.getLastName()).status(empUpdateDto.getStatus())
				.location(empUpdateDto.getLocation()).build();

		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee With Id :"+id+"Deleted Successfully";
	}

}
