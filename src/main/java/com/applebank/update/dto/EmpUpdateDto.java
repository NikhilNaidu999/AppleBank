package com.applebank.update.dto;

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
public class EmpUpdateDto {

	
	private String lastName;
	private Status status;
	private Location location;
}
