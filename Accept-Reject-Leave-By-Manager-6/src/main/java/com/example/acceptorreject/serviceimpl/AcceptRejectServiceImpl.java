package com.example.acceptorreject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.acceptorreject.model.LeaveApply;
import com.example.acceptorreject.repository.AcceptRejectRepoistory;
import com.example.acceptorreject.service.AcceptRejectService;

@Service
public class AcceptRejectServiceImpl implements AcceptRejectService{
	
	@Autowired
	private AcceptRejectRepoistory acceptRejectRepoistory;
	
	

	public AcceptRejectServiceImpl(AcceptRejectRepoistory acceptRejectRepoistory) {
		super();
		this.acceptRejectRepoistory = acceptRejectRepoistory;
	}



	@Override
	public LeaveApply getEmployeeByEmailId(String memail_id) {
		// TODO Auto-generated method stub
		return acceptRejectRepoistory.findByEmailId(memail_id);
	}



	



	@Override
	public LeaveApply acceptLeave(LeaveApply leaveapply, String memail_id) {
		// TODO Auto-generated method stub
				LeaveApply la=acceptRejectRepoistory.findByEmailId(memail_id);
				String ss=la.getLeaveStatus();
				if(ss.equals("Pending")||ss.equals("Rejected")) {
					la.setLeaveStatus("accepted");
				}
				else {
					System.out.println("pending");
				}
				return acceptRejectRepoistory.save(la);
	}



	@Override
	public LeaveApply rejectLeave(LeaveApply leaveapply, String memail_id) {
		// TODO Auto-generated method stub
		LeaveApply la12=acceptRejectRepoistory.findByEmailId(memail_id);
		if(la12!=null) {
			la12.setLeaveStatus("Rejected");
		}
		else {
			System.out.println("pending");
		}
		return acceptRejectRepoistory.save(la12);
	}







	
}
