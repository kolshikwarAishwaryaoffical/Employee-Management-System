package com.example.checkupdateprogress.service;

import com.example.checkupdateprogress.model.TaskAssign;

public interface CheckUpdateService {
	
	TaskAssign getByEmailId(String email_id);
	
	TaskAssign updateProgress(TaskAssign taskAssign,String email_id);
	
	
	
}
