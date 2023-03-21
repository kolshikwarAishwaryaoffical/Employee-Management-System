package com.example.checkupdateprogress.serviceimpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.checkupdateprogress.model.TaskAssign;
import com.example.checkupdateprogress.repository.CheckUpdateRepository;
import com.example.checkupdateprogress.service.CheckUpdateService;


@Service
public class CheckUpdateServiceImpl implements CheckUpdateService{

	@Autowired
	private CheckUpdateRepository checkUpdateRepository;


	public CheckUpdateServiceImpl(CheckUpdateRepository checkUpdateRepository) {
		super();
		this.checkUpdateRepository = checkUpdateRepository;
	}


	@Override
	public TaskAssign getByEmailId(String email_id) {
		return checkUpdateRepository.findByEmailId(email_id);
	}


	@Override
	public TaskAssign updateProgress(TaskAssign taskAssign, String email_id) {
		// TODO Auto-generated method stub
		TaskAssign taskAssign2=checkUpdateRepository.findByEmailId(email_id);
		if(taskAssign2!=null) {
			if(LocalDate.now().isBefore(taskAssign2.getDueDate())) {
				taskAssign2.setTaskProgress(taskAssign.getTaskProgress());
			}
			else {
				taskAssign2.setTaskProgress("Task Already Passed Duedate can't update progress");
			}
		}
		else {
			System.out.println("No task Assigned");

		}
		return checkUpdateRepository.save(taskAssign2);	
	}





}
