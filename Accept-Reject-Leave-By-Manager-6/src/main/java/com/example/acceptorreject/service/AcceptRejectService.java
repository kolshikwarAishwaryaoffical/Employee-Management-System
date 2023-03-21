package com.example.acceptorreject.service;



import com.example.acceptorreject.model.LeaveApply;

public interface AcceptRejectService {
	
  LeaveApply getEmployeeByEmailId(String memail_id);
  
  LeaveApply acceptLeave(LeaveApply leaveapply,String memail_id);
  
  LeaveApply rejectLeave(LeaveApply leaveapply,String memail_id);

}
