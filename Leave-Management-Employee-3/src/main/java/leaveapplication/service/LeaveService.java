package leaveapplication.service;

import leaveapplication.model.LeaveApply;
import leaveapplication.model.OnlyStatus;

public interface LeaveService {
	LeaveApply saveLeave(LeaveApply  leaveApply );
//	OnlyStatus getEmployeeByEmailId(String email_id);
	
}
