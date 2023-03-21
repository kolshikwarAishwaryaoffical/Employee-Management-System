package com.example.assigntask.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assigntask.modal.TaskAssign;
import com.example.assigntask.repository.TaskRepository;
import com.example.assigntask.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;


	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}


	@Override
	public TaskAssign saveTask(TaskAssign taskAssign) {


		taskAssign.setTaskStatus("NotCompleted");
		//taskAssign.setEmail_id(taskRepository.setEmpemailToTask(memail_id));
		
		return taskRepository.save(taskAssign);
	}

	//	@Override
	//	public String setEmpemailToTask(String memail_id) {
	//		// TODO Auto-generated method stub
	//		return  taskRepository.setEmpemailToTask(memail_id);
	//	}





}
