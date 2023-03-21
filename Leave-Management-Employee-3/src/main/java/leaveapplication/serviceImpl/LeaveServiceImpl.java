package leaveapplication.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import leaveapplication.model.LeaveApply;
import leaveapplication.model.OnlyStatus;
import leaveapplication.repository.LeaveRepository;
import leaveapplication.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService{
	
	@Autowired
	private LeaveRepository  leaveRepository;
	

	
	
	


	public LeaveServiceImpl(LeaveRepository leaveRepository) {
		super();
		this.leaveRepository = leaveRepository;
		
	}


	@Override
	public LeaveApply saveLeave(LeaveApply leaveApply) {
		// TODO Auto-generated method stub
//		leaveApply.setEmailId(null);
		return leaveRepository.save(leaveApply);
	}


//	@Override
//	public OnlyStatus getEmployeeByEmailId(String email_id) {
//		// TODO Auto-generated method stub
//		return leaveRepository.findByEmailIdstatus(email_id);
//	}


	

}
