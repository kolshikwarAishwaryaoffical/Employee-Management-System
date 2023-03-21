package com.example.assigntask.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assigntask.modal.TaskAssign;
import com.example.assigntask.service.CheckProgressService;
import com.example.assigntask.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private CheckProgressService checkProgressService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	//	@PostMapping("/{memail_id)
	//	public ResponseEntity<TaskAssign> saveTask(@RequestBody TaskAssign taskAssign,@PathVariable("memail_id")String memail_id ){
	//		return new ResponseEntity<TaskAssign>(taskService.saveTask(taskAssign,memail_id),HttpStatus.CREATED);
	//		
	//	}
	@PostMapping
	public ResponseEntity<TaskAssign> saveTask(@Valid @RequestBody TaskAssign taskAssign){
		return new ResponseEntity<TaskAssign>(taskService.saveTask(taskAssign),HttpStatus.CREATED);

	}
	
	
	@GetMapping("/{email_id}")
	public String getByEmailIdProgress(@PathVariable("email_id") String email_id) {
		String obj= new String(checkProgressService.getByEmailIdProgress(email_id));
		ObjectMapper om=new ObjectMapper();
		String progress=null;
		String op=null;
		try {
			progress=om.writeValueAsString(obj);
			String[] s1=progress.split(",");
			System.out.println(s1[6]);
		     op=s1[6];
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return op;
		
		
	}
	
	

}
