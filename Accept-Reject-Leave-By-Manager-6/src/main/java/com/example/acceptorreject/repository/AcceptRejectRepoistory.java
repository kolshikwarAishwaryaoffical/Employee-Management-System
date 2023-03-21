package com.example.acceptorreject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.acceptorreject.model.LeaveApply;

@Repository
public interface AcceptRejectRepoistory extends JpaRepository<LeaveApply, Long>{
	
	@Query(value="select * from ems.leave where memail_id=?",nativeQuery=true)
	LeaveApply findByEmailId(String memail_id);
//	List<LeaveApply> getEmployeeByEmailId(String memail_id);
//	LeaveApply acceptLeave(LeaveApply leaveapply,String memail_id);
//	  
//	  LeaveApply rejectLeave(LeaveApply leaveapply,String memail_id);
}
