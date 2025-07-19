package com.applebank.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeaveDto {
	
	private LocalDate fromDate;
	private LocalDate toDate;
	private int numberOfDays;
	private String requestedBy;
	private LocalDate requestedDate;
	private String approvedBy;
	private LocalDate approvedDate;

}
