package com.applebank.dto;

import com.applebank.model.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDto {
	
	private String name;

}
