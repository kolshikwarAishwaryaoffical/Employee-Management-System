package com.example.checkupdateprogress.controller;

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

import com.example.checkupdateprogress.model.TaskAssign;
import com.example.checkupdateprogress.service.CheckUpdateService;


@RestController
@RequestMapping("/check")
public class CheckUpdateController {
	
	@Autowired
	private CheckUpdateService checkUpdateService;

	public CheckUpdateController(CheckUpdateService checkUpdateService) {
		super();
		this.checkUpdateService = checkUpdateService;
	}
	@GetMapping("/{email_id}")
	public ResponseEntity<TaskAssign>getByEmailId(@PathVariable("email_id") String email_id){
		return new ResponseEntity<TaskAssign>(checkUpdateService.getByEmailId(email_id),HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{email_id}")
	public ResponseEntity<TaskAssign> updateEmployeeByemailid(@Valid @RequestBody TaskAssign taskAssign1,@PathVariable("email_id")String email_id) {
		return new ResponseEntity<TaskAssign>(checkUpdateService.updateProgress(taskAssign1,email_id),HttpStatus.OK);
	}
	

}
