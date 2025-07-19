package com.applebank.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applebank.dto.LeaveDto;
import com.applebank.exception.EmployeeDoesNotExistException;
import com.applebank.exception.LeaveNotFoundException;
import com.applebank.model.Leave;
import com.applebank.repository.EmployeeRepository;
import com.applebank.repository.LeaveRepository;
import com.applebank.update.dto.LeaveUpdateDto;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Leave registerLeave(LeaveDto leaveDto) {
		if (employeeRepository.findAll().contains(leaveDto.getRequestedBy())) {
			Leave leave = Leave.builder().fromDate(leaveDto.getFromDate()).toDate(leaveDto.getToDate())
					.numberOfDays(getNoOfDays(leaveDto.getFromDate(), leaveDto.getToDate()))
					.requestedBy(leaveDto.getRequestedBy()).requestedDate(leaveDto.getRequestedDate())
					.approvedBy(leaveDto.getApprovedBy()).approvedDate(leaveDto.getApprovedDate()).build();
			leaveRepository.save(leave);
			return leave;
		} else {
			throw new EmployeeDoesNotExistException("Employee :" + leaveDto.getRequestedBy() + "Does Not Exist");
		}
	}

	public static Integer getNoOfDays(LocalDate fromdate, LocalDate todate) {
		Integer days = fromdate.getDayOfMonth() - todate.getDayOfMonth();
		return days;
	}

	@Override
	public Leave fetchLeave(Long id) {
		Leave leave = leaveRepository.findById(id)
				.orElseThrow(() -> new LeaveNotFoundException("Leave With ID :" + id + "NOT_FOUND"));
		return leave;
	}

	@Override
	public List<Leave> fetchLeaves() {
		return leaveRepository.findAll();
	}

	@Override
	public Leave updateLeave(Long id, LeaveUpdateDto leaveUpdateDto) {
		Leave leave = Leave.builder().fromDate(leaveUpdateDto.getFromDate()).toDate(leaveUpdateDto.getToDate())
				.numberOfDays(leaveUpdateDto.getNumberOfDays()).approvedBy(leaveUpdateDto.getApprovedBy()).build();
		leaveRepository.save(leave);
		return leave;
	}

	@Override
	public String deleteLeave(Long id) {
		leaveRepository.deleteById(id);
		return "Leave Requested " + id + " Deleted SuccessFully";
	}

}
