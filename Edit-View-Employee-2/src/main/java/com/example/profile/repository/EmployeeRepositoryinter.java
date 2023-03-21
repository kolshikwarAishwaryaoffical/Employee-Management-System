package com.example.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.profile.model.Employee;

@Repository
public interface EmployeeRepositoryinter  extends JpaRepository<Employee,String>{
     Employee findByEmailId(String email_id);
}
