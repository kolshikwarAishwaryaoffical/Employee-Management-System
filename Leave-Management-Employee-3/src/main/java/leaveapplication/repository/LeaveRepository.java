package leaveapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import leaveapplication.model.LeaveApply;
import leaveapplication.model.OnlyStatus;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveApply, Long>{
//	@Query(value="select   leave_status from ems.leave where email_id=?",nativeQuery=true)
////	LeaveApply saveEmployee(LeaveApply  leaveApply,String emailId );
//	
//	OnlyStatus findByEmailIdstatus(String email_id);
}
