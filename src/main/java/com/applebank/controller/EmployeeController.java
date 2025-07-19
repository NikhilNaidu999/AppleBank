package com.applebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applebank.dto.EmployeeDto;
import com.applebank.dto.EmployeeDto;
import com.applebank.model.Employee;
import com.applebank.service.EmployeeService;
import com.applebank.update.dto.EmpUpdateDto;
import com.applebank.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/reg")
	public ResponseEntity<Employee> registerEmp(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<Employee>(employeeService.registerEmployee(employeeDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Employee> fetchEmployee(@PathVariable Long id){
		return new ResponseEntity<>(employeeService.fetchEmployee(id),HttpStatus.OK);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Employee>> fetchAllEmployee(){
		return new ResponseEntity<List<Employee>>(employeeService.fetchEmployees(),HttpStatus.OK);
	}
	
	@PutMapping("/modify/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody EmpUpdateDto empUpdateDto){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, empUpdateDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		return new ResponseEntity<String>(employeeService.deleteEmployee(id),HttpStatus.OK);
	}


}
