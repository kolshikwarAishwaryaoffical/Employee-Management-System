package com.example.loginadmin.service;

import java.util.List;

import com.example.loginadmin.models.Employee;
import com.example.loginadmin.models.Manager;

public interface MangerService {
	 Manager saveManager(Manager manager);
	 List<Manager> getAllManagers();
	 
}
