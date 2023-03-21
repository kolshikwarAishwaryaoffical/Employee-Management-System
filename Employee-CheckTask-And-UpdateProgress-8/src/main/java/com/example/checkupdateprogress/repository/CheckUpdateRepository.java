package com.example.checkupdateprogress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.checkupdateprogress.model.TaskAssign;

@Repository
public interface CheckUpdateRepository extends JpaRepository<TaskAssign,Long>{
	TaskAssign findByEmailId(String email_id);
}
