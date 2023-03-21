package com.example.loginadmin.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginadmin.exception.ResourceNotFoundException;
import com.example.loginadmin.models.Employee;
import com.example.loginadmin.models.Manager;
import com.example.loginadmin.repository.ManagerRepository;
import com.example.loginadmin.service.MangerService;

@Service
public class ManagerServiceImpl implements MangerService{


	@Autowired
	private ManagerRepository managerRepository;


	public ManagerServiceImpl(ManagerRepository managerRepository) {
		super();
		this.managerRepository = managerRepository;
	}

	@Override
	public Manager saveManager(Manager manager) {
		// TODO Auto-generated method stub
		Manager manager11=managerRepository.findByEmailId(manager.getEmailId());
		managerRepository.findByManagerId(manager.getManagerId());
		
		//managerRepository.find
		Manager id = managerRepository.findByManagerId(manager.getManagerId());
		
		if(id != null) {
			System.out.println("Manager already exist");
			throw new ResourceNotFoundException("Manager","ManagerId",manager.getManagerId()); 

		}
		if(manager11!=null) {
			System.out.println("Manager already exist");
			throw new ResourceNotFoundException("Manager ","emailId",manager.getEmailId());
		}

		return managerRepository.save(manager);
	}

	@Override
	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		return managerRepository.findAll();
	}

}
