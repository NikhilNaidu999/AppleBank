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

import com.applebank.dto.LeaveDto;
import com.applebank.model.Leave;
import com.applebank.service.LeaveService;
import com.applebank.update.dto.LeaveUpdateDto;

@RestController
@RequestMapping("/leave")
public class LeaveController {
	
	@Autowired
	private LeaveService leaveService;
	
	@PostMapping("/reg")
	public ResponseEntity<Leave> registerEmp(@RequestBody LeaveDto LeaveDto) {
		return new ResponseEntity<Leave>(leaveService.registerLeave(LeaveDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Leave> fetchLeave(@PathVariable Long id){
		return new ResponseEntity<Leave>(leaveService.fetchLeave(id),HttpStatus.OK);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Leave>> fetchAllLeave(){
		return new ResponseEntity<List<Leave>>(leaveService.fetchLeaves(),HttpStatus.OK);
	}
	
	@PutMapping("/modify/{id}")
	public ResponseEntity<Leave> updateLeave(@PathVariable Long id,@RequestBody LeaveUpdateDto leaveUpdateDto){
		return new ResponseEntity<Leave>(leaveService.updateLeave(id, leaveUpdateDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteLeave(@PathVariable Long id){
		return new ResponseEntity<String>(leaveService.deleteLeave(id),HttpStatus.OK);
	}


}
