package com.example.assigntask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


import com.example.assigntask.modal.TaskAssign;

public interface TaskRepository extends JpaRepository<TaskAssign, Long>{
//	@Query(value="select e.email_id from employee e,task t where e.manageremail_id=t.memail_id and t.memail_id=?",nativeQuery=true)
//	String setEmpemailToTask(String memail_id);

}
