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

import com.applebank.dto.DepartmentDto;
import com.applebank.model.Department;
import com.applebank.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/reg")
	public ResponseEntity<Department> registerDep(@RequestBody DepartmentDto departmentDto) {
		return new ResponseEntity<Department>(departmentService.registerDepartment(departmentDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Department> fetchDepartment(@PathVariable Long id){
		return new ResponseEntity<>(departmentService.fetchDepartment(id),HttpStatus.OK);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Department>> fetchAllDepartment(){
		return new ResponseEntity<List<Department>>(departmentService.fetchDepartments(),HttpStatus.OK);
	}
	
	@PutMapping("/modify/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id,@RequestBody DepartmentDto departmentDto){
		return new ResponseEntity<Department>(departmentService.updateDepartment(id, departmentDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
		return new ResponseEntity<String>(departmentService.deleteDepartment(id),HttpStatus.OK);
	}

}
