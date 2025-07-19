package com.applebank.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.applebank.enums.Gender;
import com.applebank.enums.Location;
import com.applebank.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String middelName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Gender gender;
	private LocalDate joiningDate;
	private LocalDate leavingDate;
	private Status status;
	private Location location;
	

}
