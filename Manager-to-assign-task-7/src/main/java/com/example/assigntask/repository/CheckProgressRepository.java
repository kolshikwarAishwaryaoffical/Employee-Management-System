package com.example.assigntask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.assigntask.modal.OnlyProgress;

public interface CheckProgressRepository extends JpaRepository<OnlyProgress, Long>{
	@Query(value="select * from ems.task where email_id=?",nativeQuery=true)
	String findByEmailId(String email_id);

}
