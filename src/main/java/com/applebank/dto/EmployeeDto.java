package com.applebank.dto;

import java.time.LocalDate;
import com.applebank.enums.Gender;
import com.applebank.enums.Location;
import com.applebank.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {

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
