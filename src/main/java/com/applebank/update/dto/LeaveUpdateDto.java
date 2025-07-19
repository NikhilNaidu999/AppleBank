package com.applebank.update.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeaveUpdateDto {

	
	private LocalDate fromDate;
	private LocalDate toDate;
	private int numberOfDays;
	private String approvedBy;

}
