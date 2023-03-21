package com.example.acceptorreject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.acceptorreject.model.LeaveApply;
import com.example.acceptorreject.service.AcceptRejectService;



@RestController
@RequestMapping("/updatestatus")
public class AcceptRejectController {
	
	@Autowired
	private AcceptRejectService acceptRejectService;

	public AcceptRejectController(AcceptRejectService acceptRejectService) {
		super();
		this.acceptRejectService = acceptRejectService;
	}
	
	@GetMapping("/{memail_id}")
	public ResponseEntity<LeaveApply> getEmployeeByEmailId(@PathVariable("memail_id") String memail_id){
		return new ResponseEntity<LeaveApply>(acceptRejectService.getEmployeeByEmailId(memail_id),HttpStatus.OK);
		
	}
	
	@PutMapping("/accept/{memail_id}")
	public ResponseEntity<LeaveApply> acceptLeave(@Valid @RequestBody LeaveApply leaveapply,@PathVariable("memail_id") String memail_id){
		return new ResponseEntity<LeaveApply>(acceptRejectService.acceptLeave(leaveapply, memail_id),HttpStatus.OK);
	}
	
	@PutMapping("/reject/{memail_id}")
	public ResponseEntity<LeaveApply> rejectLeave(@Valid @RequestBody LeaveApply leaveapply,@PathVariable("memail_id") String memail_id){
		return new ResponseEntity<LeaveApply>(acceptRejectService.rejectLeave(leaveapply, memail_id),HttpStatus.OK);
	}
	

}
