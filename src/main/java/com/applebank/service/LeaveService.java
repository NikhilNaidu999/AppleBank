package com.applebank.service;

import java.util.List;

import com.applebank.dto.LeaveDto;
import com.applebank.model.Leave;
import com.applebank.update.dto.LeaveUpdateDto;

public interface LeaveService {

	public Leave registerLeave(LeaveDto LeaveDto);
	public Leave fetchLeave(Long id);
	public List<Leave> fetchLeaves();
	public Leave updateLeave(Long id, LeaveUpdateDto leaveUpdateDto);
	public String deleteLeave(Long id);
}
